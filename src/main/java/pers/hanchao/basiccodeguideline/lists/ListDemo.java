package pers.hanchao.basiccodeguideline.lists;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description: 集合的 差集</P>
 *
 * @author hanchao
 * @date 2018/9/14 下午3:54
 */
public class ListDemo {
    public static void main(String[] args) {
        System.out.println("==========");

        List<String> listInES = new ImmutableList.Builder<String>().add("11", "22", "33").build();
        List<String> listInDB = new ImmutableList.Builder<String>().add("22", "33", "44").build();
        System.out.println("listInES:" + listInES);
        System.out.println("listInDB:" + listInDB);
        //新增
        List newList = listInDB.parallelStream().filter(item -> !listInES.contains(item)).collect(Collectors.toList());
        System.out.println();
        System.out.println("newList:" + newList);
        System.out.println("listInES:" + listInES);
        System.out.println("listInDB:" + listInDB);
        //过期
        List oldList = listInES.parallelStream().filter(item -> !listInDB.contains(item)).collect(Collectors.toList());
        System.out.println();
        System.out.println("oldList:" + oldList);
        System.out.println("listInES:" + listInES);
        System.out.println("listInDB:" + listInDB);
    }
}
