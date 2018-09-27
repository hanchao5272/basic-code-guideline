package pers.hanchao.basiccodeguideline.exam;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 查找中毒数组中的中毒元素</P>
 *
 * @author hanchao
 * @date 2018/9/27 上午10:23
 */
public class FindVirusTest {
    private FindVirus findVirus;

    @Before
    public void before() {
        findVirus = new FindVirusImpl();
    }

    /**
     * 空List
     **/
    @Test
    public void test1ForEmptyList() {
        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>().build()));

        assert -1 == findVirus.findVirus(list);
    }

    /**
     * 无结果
     **/
    @Test
    public void test2ForNoResult() {
        List<Integer> list = new ArrayList<>(new ImmutableList.Builder<Integer>()
                .add(1, 2, 3)
                .build());

        assert -1 == findVirus.findVirus(list);
    }

    /**
     * 无结果2
     **/
    @Test
    public void test3ForNoResult2() {
        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>()
                .add(1, 1, 2, 2)
                .build()));

        assert -1 == findVirus.findVirus(list);
    }

    /**
     * 有结果
     **/
    @Test
    public void test4ForHasResult() {
        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>()
                .add(1, 2, 2)
                .build()));

        assert 2 == findVirus.findVirus(list);
    }

    /**
     * 有结果2
     **/
    @Test
    public void test5ForHasResult2() {
        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>()
                .add(1, 2, 2, 2, 2, 1)
                .build()));

        assert 2 == findVirus.findVirus(list);
    }

    /**
     * 大集合-百万-重复值在前面-无结果
     **/
    @Test
    public void test6ForBigList() {
        Integer[] bigArray = new Integer[100000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }
        for (int i = 0; i < bigArray.length / 2 - 2; i++) {
            bigArray[i] = 5;
        }

        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>()
                .add(bigArray)
                .build()));

        assert -1 == findVirus.findVirus(list);
    }

    /**
     * 大集合-百万-重复值在前面-有结果
     **/
    @Test
    public void test7ForBigList() {
        Integer[] bigArray = new Integer[100000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }
        for (int i = 0; i < bigArray.length / 2 + 2; i++) {
            bigArray[i] = 5;
        }

        List<Integer> list = new ArrayList<>((new ImmutableList.Builder<Integer>()
                .add(bigArray)
                .build()));

        assert 5 == findVirus.findVirus(list);
    }

    /**
     * 大集合-百万-重复值在后面-无结果
     **/
    @Test
    public void test8ForBigList() {
        Integer[] bigArray = new Integer[100000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }
        for (int i = bigArray.length - 1; i > bigArray.length / 2 + 2; i--) {
            bigArray[i] = 5;
        }

        List<Integer> list = new ArrayList<>(new ImmutableList.Builder<Integer>().add(bigArray).build());

        assert -1 == findVirus.findVirus(list);
    }

    /**
     * 大集合-百万-重复值在后面-有结果
     **/
    @Test
    public void test9ForBigList() {
        Integer[] bigArray = new Integer[100000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }
        for (int i = bigArray.length - 1; i > bigArray.length / 2 - 1; i--) {
            bigArray[i] = 5;
        }

        List<Integer> list = new ArrayList<>(new ImmutableList.Builder<Integer>().add(bigArray).build());

        assert 5 == findVirus.findVirus(list);
    }
}
