package pers.hanchao.basiccodeguideline.exam;

import java.util.List;

/**
 * <p>Description: 查找病毒数字</P>
 *
 * @author hanchao
 * @date 2018/9/27 上午10:20
 */
public interface FindVirus {
    /**
     * <p>Description: </p>
     *
     * @param target 被感染的数组
     * @return 感染的数字
     * @author hanchao
     * @date 2018/9/27 上午10:21
     */
    int findVirus(List<Integer> target);
}
