package pers.hanchao.basiccodeguideline.redis.snowslide;

import lombok.Setter;
import pers.hanchao.basiccodeguideline.redis.LocalCacheService;
import pers.hanchao.basiccodeguideline.redis.MySqlService;
import pers.hanchao.basiccodeguideline.redis.RedisCacheService;

/**
 * <p>通过 多级缓存 来解决缓存雪崩</P>
 *
 * @author hanchao
 */
public class ByMultiLevelCache {
    /**
     * 是否使用一级缓存
     */
    @Setter
    private boolean useFirstCache;

    /**
     * 查询商品信息
     */
    public String getGoods(String key) {
        String value;

        //如果使用一级缓存，则首先从一级缓存中获取数据
        if (useFirstCache) {
            value = LocalCacheService.get(key);
            if (value != null) {
                return value;
            }
        }

        //如果一级缓存中无值，则查询二级缓存
        value = RedisCacheService.get(key);
        if (value != null) {
            return value;
        } else {
            //如果二级缓存中也无值，则查询数据库
            value = MySqlService.select(key);
            //缓存刷新
            RedisCacheService.set(key, value, 10);
            return value;
        }
    }
}
