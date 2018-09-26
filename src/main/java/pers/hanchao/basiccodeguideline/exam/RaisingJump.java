package pers.hanchao.basiccodeguideline.exam;

import java.util.List;

/**
 * <p>Description: 多维跳跃器</P>
 *
 * @author hanchao
 * @date 2018/9/26 下午4:51
 */
public interface RaisingJump {
    /**
     * <p>Description: 从第3维查找至第N维所需的最少步骤</p>
     *
     * @param list list.get(0)为第1维
     * @return 从第3维查找至第N维所需的最少步骤
     * @author hanchao
     * @date 2018/9/26 下午6:35
     */
    int raisingJump(List<Integer> list);
}
