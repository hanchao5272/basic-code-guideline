package pers.hanchao.basiccodeguideline.lombok;

import lombok.*;

/**
 * <p>description: lombok示例</P>
 *
 * @author hanchao
 * @date 2018/6/27 上午11:03
 */
//@EqualsAndHashCode(exclude = {"name","age"})
//@ToString(exclude = {"id", "name"})
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@RequiredArgsConstructor
@Builder
@ToString
public class Person {
    /**
     * id
     **/
//    @Setter
//    @Getter(AccessLevel.PRIVATE)
    @NonNull
    private String id;
    /**
     * 姓名
     **/
//    @Getter
//    @Setter
    @NonNull
    private String name;
    /**
     * age
     **/
//    @Getter
//    @Setter
    private Integer age;

    public static void main(String[] args) {
        Person person = Person.builder().id("11").name("David").age(12).build();
        System.out.println(person.toString());
    }
}
