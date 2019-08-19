package pers.hanchao.basiccodeguideline.redis.bloom;

import com.google.common.collect.Lists;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import pers.hanchao.basiccodeguideline.redis.MySqlService;

import java.util.List;

/**
 * <p>布隆过滤器</P>
 *
 * @author hanchao
 */
@Slf4j
public class BloomFilterDemo {
    public static void main(String[] args) {
        //定义布隆过滤器的期望填充数量
        Integer expectedInsertions = 100;
        //定义布隆过滤器：默认情况下，使用5个哈希函数已保证3%的误差率。
        BloomFilter<Long> userIdFilter = BloomFilter.create(Funnels.longFunnel(),expectedInsertions);

        //填充布隆过滤器
        //获取全部用户ID List<Long> idList = MySqlService.getAllId();
        List<Long> idList = Lists.newArrayList(521L,1314L,9527L,3721L);
        if (CollectionUtils.isNotEmpty(idList)){
            idList.forEach(userIdFilter::put);
        }

        //通过布隆过滤器判断数据是否存在
        log.info("521是否存在：{}",userIdFilter.mightContain(521L));
        log.info("125是否存在：{}",userIdFilter.mightContain(125L));
    }
}
