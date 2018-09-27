package pers.hanchao.basiccodeguideline.exam;

import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/27 上午10:22
 */
public class FindVirusImpl implements FindVirus {
    /**
     * <p>Description: </p>
     *
     * @param target 被感染的数组
     * @return 感染的数字
     * @author hanchao
     * @date 2018/9/27 上午10:21
     */
    @Override
    public int findVirus(List<Integer> target) {
        //空
        if (target == null || target.isEmpty()) {
            return -1;
        }
        System.out.println(target.size());
        for (int i = 0; i < target.size() - 1; i++) {
            System.out.print(target.get(i) + " ");
        }
        System.out.print(target.get(target.size() - 1));

        //排序
        target.sort(Integer::compareTo);
        //当前元素
        int currentValue = 0, currentCount = 0;

        for (int i = 0; i < target.size(); i++) {
            //有值累加
            if (target.get(i) == currentValue) {
                currentCount++;
                //找到返回
                if (currentCount > target.size() / 2) {
                    return target.get(i);
                }
            } else {
                //当前值不满足需求，换下一个
                currentValue = target.get(i);
                currentCount = 1;
            }
        }
        return -1;
    }
}
