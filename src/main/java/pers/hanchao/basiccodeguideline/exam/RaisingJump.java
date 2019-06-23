package pers.hanchao.basiccodeguideline.exam;

import java.util.List;

/**
 * <p>Description: 多维跳跃器</P>
 * 你发现一个未知科技制造的多维度跳跃器。它在每个维度都有一个指数，可以帮你升维跃迁到最大为当前维度+这个指数的维度上。
 * 现在已知这个仪器在每个维度的数值，从1维到N维，均为大于0的正数，用一个N长数组表示。你从3维出发，请问最少需要几次跃迁到达第N维。
 * <p>
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
