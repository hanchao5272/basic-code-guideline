package pers.hanchao.basiccodeguideline.exam;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/26 下午2:27
 */
public class RaisingJumpDemo implements RaisingJump {
    /**
     * 日志
     **/
    private static final Logger logger = Logger.getLogger(RaisingJumpDemo.class);

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
            logger.info("起始维度不合法，无法跳跃");
            return -1;
        }
        if (beginDimension == list.size()) {
            logger.info("起始维度为N，无需跳跃");
            return 0;
        }
        int length = list.size();
        int[][] array = new int[length][length];
        //显示当前维度转换器
        logger.info("多维跳跃器：" + list);
        logger.info("多维跳跃器维度详情：");
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                logger.info(String.format("%d维，指数=%d，跳维范围[%d维 -> %d维]", i + 1, list.get(i), i + 1, i + 1 + list.get(i)));
                //将二维数组转换成树
                for (int j = 0; j < list.get(i); j++) {
                    array[i][j] = i + 1 + j + 1;
                }
            } else {
                logger.info(String.format("%d维，指数=%d，无需跳维\n", i, list.get(i)));
            }
        }

        logger.info("将其转换成广度图：");
        for (int i = 0; i < array.length; i++) {
            StringBuilder msg = new StringBuilder().append(i + 1).append("维可达: ");
            for (int j = 0; j < array[i].length; j++) {
                msg.append(array[i][j]).append(" ");
            }
            logger.info(msg.toString());
        }
        List<Integer> result = new ArrayList<>();

        //递归反向查找
        findMinStep(result, array, beginDimension - 1, list.size());

        String steps = "最少步骤：";
        for (int i = result.size() - 1; i >= 0; i--) {
            steps += (String.format("%d --> ", result.get(i)));
        }
        steps += length;
        System.out.println();

        logger.info(String.format("从%d维跳跃值%d维，至少需要%d步", beginDimension, list.size(), result.size()));
        logger.info(steps);

        return result.size();
    }

    /**
     * <p>Description: 递归查找并添加上一步的维度</p>
     *
     * @param result     最少步数结果集
     * @param array      广度二维数组
     * @param beginIndex 开始下标
     * @param dest       目标值
     * @author hanchao
     * @date 2018/9/26 下午4:45
     */
    private static void findMinStep(List<Integer> result, int[][] array, int beginIndex, int dest) {
        int lastIndex = 0;
        boolean stop = false;
        for (int i = beginIndex; i < array.length; i++) {
            if (!stop) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == dest) {
                        lastIndex = i;
                        //i为上一个维度
                        result.add(i + 1);
                        stop = true;
                        break;
                    }
                }
            }
        }
        if (lastIndex != beginIndex) {
            //递归
            findMinStep(result, array, beginIndex, lastIndex);
        }
    }

    /**
     * <p>Description: 从第3维查找至第N维，list.get(0)为第1维</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午4:52
     */
    @Override
    public int raisingJump(List<Integer> map) {
        return raisingJump(map, 3);
    }
}
