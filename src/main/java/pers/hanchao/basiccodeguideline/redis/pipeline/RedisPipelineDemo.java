package pers.hanchao.basiccodeguideline.redis.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBatch;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * <p>Redis Pipeline Demo</P>
 *
 * @author hanchao
 */
@Slf4j
public class RedisPipelineDemo {
    public static void main(String[] args) {
        //连接redis
        Jedis jedis = new Jedis("10.126.42.16", 26379);
        //获取pipeline
        Pipeline pipeline = jedis.pipelined();

        //普通模式
        String zSetKey = "pipeline-test-";
        int size = 1000;

        Long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            jedis.zadd(zSetKey + i, i, String.valueOf(i));
            jedis.zadd(zSetKey, i + 1, String.valueOf(i + 1));
        }
        log.info("普通模式耗时：{}", (System.currentTimeMillis() - begin));

        //pipeline模式
        begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            pipeline.zadd(zSetKey + i, i, String.valueOf(i));
            pipeline.zadd(zSetKey, i + 1, String.valueOf(i + 1));
        }
        pipeline.sync();
        log.info("pipeline模式(Jedis)耗时：{}", (System.currentTimeMillis() - begin));

        //连接redis
        Config config = new Config();
        config.useSingleServer().setAddress("redis://10.126.42.16:26379");
        RedissonClient redisson = Redisson.create(config);
        RBatch redisBatch = redisson.createBatch();

        begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            redisBatch.getScoredSortedSet(zSetKey + i).addAsync(i,String.valueOf(i));
            redisBatch.getScoredSortedSet(zSetKey).addAsync(i + 1,String.valueOf(i + 1));
        }
        redisBatch.execute();
        log.info("pipeline模式(Redission)耗时：{}", (System.currentTimeMillis() - begin));

        //关闭
        pipeline.close();
        jedis.close();
        redisson.shutdown();
    }
}
