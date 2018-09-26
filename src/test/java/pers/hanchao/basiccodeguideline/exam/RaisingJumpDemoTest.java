package pers.hanchao.basiccodeguideline.exam;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/26 下午4:46
 */
public class RaisingJumpDemoTest {

    private RaisingJump raisingJump;

    @Before
    public void before() {
        raisingJump = new RaisingJumpDemo();
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
    public void test10ForLargeStep() {
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
    public void test9ForComplexList() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 5, 4, 1, 1, 1, 2, 1, 1, 2, 1, 1, 3, 10, 1, 1, 1, 1)
                .build();

        assert 8 == raisingJump.raisingJump(list);
    }
}
