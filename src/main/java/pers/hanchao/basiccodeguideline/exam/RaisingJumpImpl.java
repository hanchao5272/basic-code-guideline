package pers.hanchao.basiccodeguideline.exam;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * <p>Description: 多维跳跃器实现</P>
 *
 * @author hanchao
 * @date 2018/9/26 下午2:27
 */
public class RaisingJumpImpl implements RaisingJump {
    /**
     * 日志
     **/
    private static final Logger logger = Logger.getLogger(RaisingJumpImpl.class);

    /**
     * <p>Description: 从第3维查找至第N维所需的最少步骤</p>
     *
     * @param list list.get(0)为第1维
     * @return 从第3维查找至第N维所需的最少步骤
     * @author hanchao
     * @date 2018/9/26 下午6:35
     */
    @Override
    public int raisingJump(List<Integer> list) {
        return raisingJump(list, 3);
    }

    /**
     * <p>Description: 跳维</p>
     *
     * @param list           从第3维查找至第N维，list.get(0)为第1维
     * @param beginDimension 开始维度
     * @author hanchao
     * @date 2018/9/26 下午4:45
     */
    public static Integer raisingJump(List<Integer> list, Integer beginDimension) {
        if (list == null || list.isEmpty()) {
            logger.info("0维跳跃器无法跳跃");
            return -1;
        }
        if (beginDimension > list.size() || beginDimension < 0) {
            logger.info("起始维度大于转换器长度，无法跳跃");
            return -1;
        }
        if (beginDimension == list.size()) {
            logger.info("起始维度为N，无需跳跃");
            return 0;
        }
        //是否存在直接可达的情况
        if (beginDimension + list.get(beginDimension - 1) >= list.size()) {
            logger.info(String.format("[%d -> %d维]，只需1步，直接跳跃即可", beginDimension, list.size()));
            return 1;
        } else {
            int tempMaxIndex = 0;
            int minStep = 0;
            //显示当前维度转换器
            logger.info(list.size());
            logger.info(list);
            logger.info("跳跃过程：");
            for (int i = beginDimension - 1; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    int maxIndex = i + 1 + list.get(i) > list.size() ? list.size() : i + 1 + list.get(i);
                    if (maxIndex > tempMaxIndex) {
                        logger.info(String.format("%d维，指数=%d，跳维范围：[%d维 -> %d维]", i + 1, list.get(i), i + 1, maxIndex));
                        tempMaxIndex = maxIndex;
                        minStep++;
                    }
                }
            }

            logger.info(String.format("从%d维跳跃值%d维，至少需要%d步", beginDimension, list.size(), minStep));
            return minStep;
        }
    }
}
