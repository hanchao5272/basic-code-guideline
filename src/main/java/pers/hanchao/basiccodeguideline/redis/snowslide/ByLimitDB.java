package pers.hanchao.basiccodeguideline.redis.snowslide;

import pers.hanchao.basiccodeguideline.redis.MySqlService;
import pers.hanchao.basiccodeguideline.redis.RedisCacheService;

/**
 * <p>通过 为数据库访问加锁 来解决缓存雪崩</P>
 *
 * @author hanchao
 */
public class ByLimitDB {
    /**
     * 用于加锁的对象
     */
    private static final byte[] LOCK_OBJ = new byte[0];

    /**
     * 获取商品信息
     */
    public String getGoodsByLock(String key) {
        //获取缓存值
        String value = RedisCacheService.get(key);

        // 如果缓存有值，就直接取出来即可
        if (value != null) {
            return value;
        } else {
            //对数据库的访问进行加锁限制
            synchronized (LOCK_OBJ) {
                value = RedisCacheService.get(key);
                if (value != null) {
                    return value;
                } else {
                    //访问数据库
                    value = MySqlService.select(key);
                    //缓存刷新
                    RedisCacheService.set(key, value, 10);
                }
            }
            return value;
        }
    }
}
