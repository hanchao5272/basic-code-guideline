package pers.hanchao.basiccodeguideline.exam;

import java.util.List;

/**
 * <p>Description: 查找病毒数字</P>
 * 存储器不幸被某种奇怪的病毒感染。这种病毒选择一个数组，生成自己的标号——一个合法但被感染原始数组中没有的数字。
 * 然后会的疯狂的复制自己的标号，并且用他随机替换数组中的合法数字。
 * 现在有一个超过一半都被感染的数组，请你找出哪个数字是病毒的标号。请尽量使用时间空间复杂度低的算法
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
