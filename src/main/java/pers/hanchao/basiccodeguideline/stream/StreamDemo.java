package pers.hanchao.basiccodeguideline.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>description: Stream示例</P>
 *
 * @author hanchao
 * @date 2018/6/28 下午5:22
 */
public class StreamDemo {
    public static void main(String[] args) {

        /** 获取流的三种方式 **/
        //1.集合转流
        List<Person> list = Arrays.asList(new Person("张三", true, 12),
                new Person("张三", true, 12),
                new Person("李四", true, 15),
                new Person("王五", false, 22),
                new Person("陈六", true, 23));
        Stream<Person> stream = list.stream();

        //2.数组工具类
        Person[] arrays = new Person[]{new Person("张三", true, 12),
                new Person("李四", true, 15),
                new Person("王五", false, 22),
                new Person("陈六", true, 23)};
        Stream<Person> stream1 = Arrays.stream(arrays);

        //3.直接定义流
        Stream<Person> stream2 = Stream.of(new Person("张三", true, 12),
                new Person("李四", true, 15),
                new Person("王五", false, 22),
                new Person("陈六", true, 23));

        /** stream 与 parallelStream **/
        //单行流
        Stream stream3 = list.stream();
        //并行流
        Stream stream4 = list.parallelStream();

        /** 遍历forEach **/
        //forEach输出，针对List和Map
        System.out.println("=====遍历forEach=====");
        list.forEach(System.out::println);
        list.stream().forEach(System.out::println);

        /** 筛选filter **/
        System.out.println("=====筛选filter=====");
        //filter,过滤元素；注意filter中是返回boolean类型的lambda表达式，
        list.stream().filter(Person::getStudent).forEach(System.out::println);

        /** 去重distinct **/
        System.out.println("=====去重distinct=====");
        list.stream().distinct().forEach(System.out::println);

        /** 截取limit **/
        System.out.println("=====截取limit=====");
        list.stream().limit(2).forEach(System.out::println);

        /** 跳过skip **/
        System.out.println("=====跳过skip=====");
        list.stream().skip(2).forEach(System.out::println);

        /** 映射map：转换元素类型 **/
        System.out.println("=====映射map：转换元素类型=====");
        list.stream().map(Person::getName).forEach(System.out::println);
        List<String> list1 = list.stream().map(Person::getName).collect(Collectors.toList());

        /** 合并流flatmap **/
        System.out.println("=====合并流flatmap=====");
        List<String> list2 = Arrays.asList("I am a boy", "I love the girl", "But the girl loves another girl");
        list2.stream()//转换成流
                //String -> String[]
                .map(element -> element.split(" "))
                //String[] -> Stream
                .flatMap(Arrays::stream)
                //去重
                .distinct()
                //遍历输出
                .forEach(System.out::println);

        /** 是否匹配任一元素：anyMatch **/
        System.out.println("是否匹配任一元素：anyMatch");
        System.out.println(list.stream().anyMatch(person -> person.getAge().equals(12)));

        /** 是否匹配所有元素：allMatch **/
        System.out.println("是否匹配所有元素：allMatch");
        System.out.println(list.stream().allMatch(Person::getStudent));

        /** 是否未匹配所有元素：noneMatch **/
        System.out.println("是否未匹配所有元素：noneMatch");
        System.out.println(list.stream().allMatch(person -> person.getName().equals("张三丰")));

        /** 获取任一元素findAny **/
        Optional<Person> person = list.stream().findAny();

        /** 获取第一个元素findFirst **/
        Optional<Person> person1 = list.stream().findFirst();

        /** 归约：将多个元素折叠成一个元素输出 **/
        /** 归约：使用Integer.sum函数求和 **/
        System.out.println("使用Integer.sum函数求和");
        int age = list.stream()
                //将Person转换成int
                .map(Person::getAge)
                //利用Integer的sum方法求和
                .reduce(0, Integer::sum);
        System.out.println(age);

        /** 普通流转换成特殊流-更高效 **/
        System.out.println("普通流转换成特殊流-更高效");
        System.out.println(list.stream()
                //将Person转换成int
                .mapToInt(Person::getAge)
                //利用Integer的sum方法求和
                .reduce(0, Integer::sum));

        /** 其他数值方法 **/
        System.out.println("其他数值方法");
        System.out.println("max = " + list.stream().mapToInt(Person::getAge).max());
        System.out.println("avg = " + list.stream().mapToInt(Person::getAge).average());
        System.out.println("count = " + list.stream().mapToInt(Person::getAge).count());
        System.out.println("min = " + list.stream().mapToInt(Person::getAge).min());
        System.out.println("sum = " + list.stream().mapToInt(Person::getAge).sum());

        /** 终端操作 **/
        //流转换成List
        System.out.println("数组形成的流转换成List");
        List<Person> list3 = Stream.of(arrays).collect(Collectors.toList());
        list3.stream().forEach(System.out::println);

        //流转换成Set
        System.out.println("流转换成Set");
        Set<Person> set = list.stream().collect(Collectors.toSet());
        set.stream().forEach(System.out::println);

        //关于null值和空数组
        System.out.println("关于null值和空数组");
        Stream.of(null).forEach(System.out::println);
        Stream.of(Arrays.asList()).forEach(System.out::println);
    }
}
