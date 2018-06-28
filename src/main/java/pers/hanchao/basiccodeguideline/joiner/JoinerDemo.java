package pers.hanchao.basiccodeguideline.joiner;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>description: 字符串拼接器示例</P>
 *
 * @author hanchao
 * @date 2018/6/28 下午4:42
 */
public class JoinerDemo {
    public static void main(String[] args) {
        //忽略null值拼接
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList("北京", "天津", null, "大连")));
        //替换null值拼接
        System.out.println(Joiner.on(",").useForNull("默认").join(Arrays.asList("北京", "天津", null, "大连")));
        //处理map
        Map map = new HashMap<String, String>();
        map.put("001", "zhangsan");
        map.put("002", "李四");
        map.put("003", null);
        System.out.println(Joiner.on(",").useForNull("默认").withKeyValueSeparator(":").join(map));
        //动态拼接
        StringBuilder stringBuilder = new StringBuilder("result: ");
        System.out.println(Joiner.on(",").appendTo(stringBuilder, 1, "good", 2));
        System.out.println(Joiner.on(",").appendTo(stringBuilder, new Object[]{"1", 2, false}));
    }
}

