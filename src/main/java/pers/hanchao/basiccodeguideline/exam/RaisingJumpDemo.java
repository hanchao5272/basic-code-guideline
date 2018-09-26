package pers.hanchao.basiccodeguideline.exam;

import com.google.common.collect.ImmutableList;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/26 下午2:27
 */
public class RaisingJumpDemo implements RaisingJump{
    /**
     * 日志
     **/
    private static final Logger logger = Logger.getLogger(RaisingJumpDemo.class);

    public static void main(String[] args) {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(0, 2, 3, 1, 1, 5)
                .build();

        raisingJump(list, 1);
    }

    /**
    * <p>Description: 跳维</p>
    * @author hanchao
    * @date 2018/9/26 下午4:45
    */
    public static Integer raisingJump(List<Integer> list, Integer beginIndex) {
        if (list == null || list.isEmpty()) {
            logger.info("0维跳跃器无法跳跃");
            return -1;
        }
        if (beginIndex >= list.size() || beginIndex <= 0) {
            logger.info("起始维度不合法，无法跳跃");
            return -1;
        }
        if (beginIndex == list.size()) {
            logger.info("起始维度为N，无需跳跃");
            return 0;
        }
        int length = list.size() - 1;
        int[][] array = new int[length][length];
        //显示当前维度转换器
        logger.info("多维跳跃器如下：");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {

            } else if (i < list.size() - 1) {
                logger.info(String.format("%d维，指数=%d，跳维范围[%d维 -> %d维]", i, list.get(i), i, i + list.get(i)));
                //将二维数组转换成树
                for (int j = 0; j < list.get(i); j++) {
                    array[i][j] = i + j + 1;
                }
            } else {
                logger.info(String.format("%d维，指数=%d，无需跳维\n", i, list.get(i)));
            }
        }

        logger.info("将其转换成广度图：");
        for (int i = 0; i < array.length; i++) {
            String msg = "";
            for (int j = 0; j < array[i].length; j++) {
                msg += array[i][j] + " ";
            }
            logger.info(msg);
        }
        List<Integer> result = new ArrayList<>();

        //递归反向查找
        findMinStep(result, array, beginIndex, list.size() - 1);

        String steps = "最少步骤：";
        for (int i = result.size() - 1; i >= 0; i--) {
            steps += (String.format("%d --> ",result.get(i)));
        }
        steps += length;
        System.out.println();

        logger.info(String.format("从%d维跳跃值%d维，至少需要%d步", beginIndex, list.size() - 1, result.size()));
        logger.info(steps);

        return result.size();
    }

    /**
    * <p>Description: 递归查找并添加上一步的维度</p>
    * @author hanchao
    * @date 2018/9/26 下午4:45
    */
    private static void findMinStep(List<Integer> result, int[][] array, int beginIndex, int dest) {
        int lastIndex = 0;
        boolean stop = false;
        for (int i = beginIndex; i < array.length; i++) {
            if (!stop){
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == dest) {
                        lastIndex = i;
                        //i为上一个维度
                        result.add(i);
                        stop = true;
                        break;
                    }
                }
            }
        }
        if (lastIndex != beginIndex){
            //递归
            findMinStep(result, array, beginIndex, lastIndex);
        }
    }

    /**
    * <p>Description: 从3查找至N</p>
    * @author hanchao
    * @date 2018/9/26 下午4:52
    */
    @Override
    public int raisingJump(List<Integer> map) {
        return raisingJump(map,3);
    }
}
