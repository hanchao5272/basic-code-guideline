package pers.hanchao.basiccodeguideline.repeatelement;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: List.add重复元素的坑=引用对象的地址引用</P>
 *
 * @author hanchao
 * @date 2018/8/6 下午3:32
 */
public class RepeatElementOfList {
    public static void main(String[] args) {
        //错误的编码方式
        List<Person> people1 = new ArrayList<>();
        Person person1 = new Person();
        for (int i = 0; i < 4; i++) {
            person1.setName("姓名" + i);
            person1.setStudent(true);
            person1.setAge(18 + i);
            people1.add(person1);
        }
        people1.forEach(System.out::println);
        System.out.println();

        //正确的编码方式
        List<Person> people2 = new ArrayList<>();
        Person person2;
        for (int i = 0; i < 4; i++) {
            //重新分配地址
            person2 = new Person();
            person2.setName("姓名" + i);
            person2.setStudent(true);
            person2.setAge(18 + i);
            people2.add(person2);
        }
        people2.forEach(System.out::println);
        System.out.println();

        //////

        //错误的编码方式
        List<Person> people3 = new ArrayList<>();
        Person person3;
        for (int i = 0; i < 3; i++) {
            //重新分配地址
            person3 = new Person();
            person3 = PersonUtils.getPerson();
            person3.setAge(person3.getAge() + i);
            people3.add(person3);
        }
        people3.forEach(System.out::println);
        System.out.println();

        //正确的编码方式
        List<Person> people4 = new ArrayList<>();
        Person person4;
        for (int i = 0; i < 3; i++) {
            //重新分配地址
            person4 = new Person();
            Person tPerson = PersonUtils.getPerson();
            BeanUtils.copyProperties(tPerson,person4);
            person4.setAge(person4.getAge() + i);
            people4.add(person4);
        }
        people4.forEach(System.out::println);
        System.out.println();

    }
}
