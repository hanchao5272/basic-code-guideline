package pers.hanchao.basiccodeguideline.redis.snowslide;


import org.apache.commons.lang3.RandomUtils;

/**
 * <p>通过 随机过期时间 来解决缓存雪崩</P>
 *
 * @author hanchao
 */
public class ByRandomExpire {
    /**
     * 获取随机失效时间
     *
     * @param originExpire 原定失效时间
     * @param randomScope  最大随机范围
     * @return 随机失效时间
     */
    public static Long getRandomExpire(Long originExpire, Long randomScope) {
        return originExpire + RandomUtils.nextLong(0, randomScope);
    }
}
