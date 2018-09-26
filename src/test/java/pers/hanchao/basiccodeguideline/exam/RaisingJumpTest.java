package pers.hanchao.basiccodeguideline.exam;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * <p>Description: 多维跳跃器测试</P>
 *
 * @author hanchao
 * @date 2018/9/26 下午4:46
 */
public class RaisingJumpTest {

    private RaisingJump raisingJump;

    @Before
    public void before() {
        raisingJump = new RaisingJumpImpl();
    }

    /**
     * <p>Description: 数组长度小于3</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:55
     */
    @Test
    public void test1ForListIsEmpty() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .build();

        assert -1 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 数组长度小于3</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:55
     */
    @Test
    public void test2ForBeginDimensionIsTooLarge() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1)
                .build();

        assert -1 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 数组长度正好为3</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:55
     */
    @Test
    public void test3ForNDimensionEqual3() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 3)
                .build();

        assert 0 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 第3维度正好可以跳至N维度</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test4For3DimensionJustRightDirectJumpToNDimension() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 6, 1, 1, 1, 1, 1, 1)
                .build();

        assert 1 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 第3维度可以跳至N维度</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test5For3DimensionCanDirectJumpToNDimension() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 100, 1, 1, 1, 1, 1, 1)
                .build();

        assert 1 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 第3维度正好可以跳至N维度</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test6For3DimensionCanNotDirectJumpToNDimension() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 5, 1, 1, 1, 1, 1, 1)
                .build();

        assert 2 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 每个指数都是1</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test7ForEveryStepIsOne() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 1, 1, 1, 1, 1, 1, 1)
                .build();

        assert 6 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 存在两种最短步数</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test8ForTwoMinStepChoose() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 5, 4, 1, 1, 1, 1)
                .build();

        assert 2 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 指数特别大</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test9ForLargeStep() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 5, 4, 1, 1, 1, 1000, 1, 1, 1, 1)
                .build();

        assert 3 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 复杂的例子</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test10ForComplexList() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 5, 4, 1, 1, 1, 2, 1, 1, 2, 1, 1, 3, 10, 1, 1, 1, 1)
                .build();

        assert 8 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 大数组</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test11ForLargeList() {
        Integer[] largeArray = new Integer[10000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = 1;
        }

        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 5, 4, 1, 1, 1, 2, 1, 1, 2, 1, 1, 3, 10000000, 1, 1, 1, 1)
                .add(largeArray)
                .build();

        assert 12 == raisingJump.raisingJump(list);
    }

    /**
     * <p>Description: 复杂的例子</p>
     *
     * @author hanchao
     * @date 2018/9/26 下午5:56
     */
    @Test
    public void test12ForLargeList() {
        Integer[] largeArray = new Integer[10000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = RandomUtils.nextInt(1);
        }
        //
        largeArray[2] = 2;
        largeArray[3] = 1;
        largeArray[4] = 30;

        largeArray[30] = 2;
        largeArray[31] = 300 - 31;
        largeArray[32] = 1;

        largeArray[300] = 2;
        largeArray[301] = 1;
        largeArray[302] = 3000- 302;

        largeArray[3000] = 3;
        largeArray[3001] = 1;
        largeArray[3002] = 30000 - 3002;
        largeArray[3003] = 30000 - 3002 - 10;
        largeArray[3004] = 30000 - 3002 - 20;

        largeArray[30000] = 10000000;

        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(largeArray)
                .build();

        assert 8 == raisingJump.raisingJump(list);
    }

}
