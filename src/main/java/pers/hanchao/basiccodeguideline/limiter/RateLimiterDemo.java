package pers.hanchao.basiccodeguideline.limiter;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>令牌桶限流器实例</P>
 *
 * @author hanchao
 */
public class RateLimiterDemo {
    /**
     * 日志
     **/
    private static final Logger logger = Logger.getLogger(RateLimiterDemo.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException {
        //permitsPerSecond = 每秒产生的令牌桶
        //
        RateLimiter rateLimiter = RateLimiter.create(0.0333D);
        Thread.sleep(300000);

        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                if (rateLimiter.tryAcquire(30,TimeUnit.SECONDS)){
                    logger.info("抢购成功");
                }else {
                    logger.info("抢购失败!!!!!!");
                }
            });
        }

        executorService.shutdown();
    }


}
