package pers.hanchao.basiccodeguideline.repeatelement;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * <p>Description: 人员工具类</P>
 *
 * @author hanchao
 * @date 2018/8/6 下午3:42
 */
public class PersonUtils {
    private static Map map = new ImmutableMap.Builder<Integer,Person>()
            .put(0,new Person("汤姆",true,18))
            .build();

    public static Person getPerson(){
        return (Person) map.get(0);
    }
}
