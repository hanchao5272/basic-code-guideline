package pers.hanchao.basiccodeguideline.redlock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * <p>RedLock的简单并发测试</P>
 *
 * @author hanchao
 */
@Slf4j
public class RedLockTestDemo {
    public static void main(String[] args) throws InterruptedException {
        //连接redis
        Config config = new Config();
        config.useSingleServer().setAddress("redis://10.126.42.16:26379");
        RedissonClient redisson = Redisson.create(config);

        //锁的名字
        String key = "myTest001";
        //尝试加锁的超时时间
        Long timeout = 1000L;
        //锁过期时间
        Long expire = 30L;
        //并发数
        Integer size = 1000;

        //定义线程池
        ExecutorService executorService = Executors.newFixedThreadPool(size);

        //定义倒计时门闩：以保证所有线程执行完毕再进行最后的计数
        CountDownLatch latchCount = new CountDownLatch(size);

        //计数器
        LongAdder adderSuccess = new LongAdder();
        LongAdder adderFail = new LongAdder();

        //多线程执行
        for (int i = 0; i < size; i++) {
            executorService.execute(() -> {
                //定义锁
                RLock lock = redisson.getLock(key);
                try {
                    //获取锁
                    if (lock.tryLock(timeout, expire, TimeUnit.MILLISECONDS)) {
                        //成功计数器累加1
                        adderSuccess.increment();
                        latchCount.countDown();
                    } else {
                        //失败计数器累加1
                        adderFail.increment();
                        latchCount.countDown();
                    }
                } catch (InterruptedException e) {
                    log.error("尝试获取分布式锁失败", e);
                } finally {
                    //释放锁
                    try {
                        lock.unlock();
                    } catch (Exception e) {
                        //do nothing
                    }
                }
            });
        }
        //等待所有线程执行完毕
        latchCount.await();

        //关闭线程池
        executorService.shutdown();

        //关闭连接
        redisson.shutdown();

        log.info("共计「{}」获取锁成功，「{}」获取锁失败。", adderSuccess.intValue(), adderFail.intValue());
    }
}
