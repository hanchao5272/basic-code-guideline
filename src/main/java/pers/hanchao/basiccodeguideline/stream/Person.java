package pers.hanchao.basiccodeguideline.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>description: 人员</P>
 *
 * @author hanchao
 * @date 2018/6/28 下午5:49
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Boolean student;
    private Integer age;
}
