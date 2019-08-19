package pers.hanchao.basiccodeguideline.redis.snowslide;

import pers.hanchao.basiccodeguideline.redis.MySqlService;
import pers.hanchao.basiccodeguideline.redis.RedisCacheService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>通过 缓存刷新标记 来解决缓存雪崩</P>
 *
 * @author hanchao
 */
public class ByRefreshMark {
    /**
     * 线程池：用于异步刷新缓存
     */
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    /**
     * 缓存刷新标记后缀
     */
    public static final String REFRESH_SUFFIX = "_r";

    /**
     * 获取缓存刷新标记的key
     */
    public String getRefreshKey(String key) {
        return key + REFRESH_SUFFIX;
    }

    /**
     * 判断无需刷新: 刷新标记存在，则表示不需要刷新
     */
    public boolean notNeedRefresh(String key) {
        return RedisCacheService.containsKey(key + REFRESH_SUFFIX);
    }

    /**
     * 获取商品信息
     */
    public String getGoods(String key) {
        //获取缓存值
        String value = RedisCacheService.get(key);

        //过期时间
        Long expire = 10L;

        //如果无需刷新，则直接返回缓存值
        if (notNeedRefresh(key)) {
            //理论上：如果缓存刷新标记存在，则缓存必存在，所以可以直接返回
            return value;
        } else {
            //如果需要刷新，则重置缓存刷新标记的过期时间
            RedisCacheService.set(getRefreshKey(key), "1", expire / 2);

            //如果缓存有值，就直接返回即可
            if (value != null) {
                //因为有值，所以可以异步刷新缓存
                executorService.submit(() -> {
                    //访问数据库
                    String newValue = MySqlService.select(key);
                    //缓存刷新
                    RedisCacheService.set(key, newValue, expire);
                });

                return value;
            } else {
                //因为无值，所以还是要同步刷新缓存
                value = MySqlService.select(key);
                //缓存刷新
                RedisCacheService.set(key, value, expire);

                return value;
            }
        }
    }
}
