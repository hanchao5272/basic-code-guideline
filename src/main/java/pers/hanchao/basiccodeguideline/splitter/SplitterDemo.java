package pers.hanchao.basiccodeguideline.splitter;

import com.google.common.base.Splitter;

/**
 * <p>Description: 字符串拆分示例</P>
 *
 * @author hanchao
 * @date 2018/7/3 下午7:38
 */
public class SplitterDemo {
    public static void main(String[] args) {
        String list = "入驻类型-个人入驻,入驻方式-官方邀约";
        Splitter.on(",").splitToList(list).forEach(System.out::println);
    }
}
