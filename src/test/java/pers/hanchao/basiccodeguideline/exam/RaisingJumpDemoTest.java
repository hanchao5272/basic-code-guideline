package pers.hanchao.basiccodeguideline.exam;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/26 下午4:46
 */
public class RaisingJumpDemoTest {

    @Test
    public void test1() {
        List<Integer> list = new ImmutableList.Builder<Integer>()
                .add(0, 1, 1, 2, 3, 1, 1, 5)
                .build();

        RaisingJump raisingJump = new RaisingJumpDemo();
        raisingJump.raisingJump(list);
    }
}
