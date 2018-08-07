package pers.hanchao.basiccodeguideline.repeatelement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>description: 人员</P>
 *
 * @author hanchao
 * @date 2018/6/28 下午5:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Boolean student;
    private Integer age;
}
