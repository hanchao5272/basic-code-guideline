package pers.hanchao.basiccodeguideline.redis.penetrate;

import com.google.common.collect.Sets;
import pers.hanchao.basiccodeguideline.redis.MySqlService;
import pers.hanchao.basiccodeguideline.redis.RedisCacheService;

import java.util.Set;

/**
 * <p>通过 缓存重建加锁 解决缓存穿透问题</P>
 *
 * @author hanchao
 */
public class ByLimitCacheRebuild {
    /**
     * 用于加锁的对象
     */
    private static final byte[] LOCK_OBJ = new byte[0];

    /**
     * 通过某种手段判断一个值是热点key。这里为了示例直接硬编码
     */
    private Set<String> hotKeySet = Sets.newHashSet("521", "1314");

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
            //如果是热点key，则对缓存重建过程进行加锁
            if (hotKeySet.contains(key)) {
                //对缓存重建过程进行加锁限制
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
            } else {
                //如果是普通Key，无需对缓存重建加锁
                value = MySqlService.select(key);
                //缓存刷新
                RedisCacheService.set(key, value, 10);
            }

            return value;
        }
    }
}
