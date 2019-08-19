package pers.hanchao.basiccodeguideline.redis.penetrate;

import pers.hanchao.basiccodeguideline.redis.MySqlService;
import pers.hanchao.basiccodeguideline.redis.RedisCacheService;

/**
 * <p>通过 空值缓存 解决缓存穿透问题</P>
 *
 * @author hanchao
 */
public class ByNullCache {
    /**
     * 缓存空值
     */
    public static final String NULL_CACHE = "_";

    /**
     * 获取商品信息
     */
    public String getGoodsByLock(String key) {
        //获取缓存值
        String value = RedisCacheService.get(key);

        //如果缓存有值
        if (value != null) {
            //如果缓存的是空值，则直接返回空，无需查询数据库
            if (NULL_CACHE.equals(value)) {
                return null;
            } else {
                return value;
            }
        } else {
            //访问数据库
            value = MySqlService.select(key);
            //如果数据库有值，则直接返回
            if (value != null) {
                //缓存刷新
                RedisCacheService.set(key, value, 10);
                return value;
            } else {
                //如果数据库无值，则设置空值缓存
                RedisCacheService.set(key, NULL_CACHE, 5);
                return null;
            }
        }
    }
}
