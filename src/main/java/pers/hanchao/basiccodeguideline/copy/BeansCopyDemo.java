package pers.hanchao.basiccodeguideline.copy;

import org.springframework.beans.BeanUtils;
import pers.hanchao.basiccodeguideline.lombok.Person;

/**
 * <p>Description: Bean拷贝示例</P>
 *
 * @author hanchao
 * @date 2018/9/3 下午6:02
 */
public class BeansCopyDemo {
    public static void main(String[] args) {
        /** 拷贝会复制所有字段 **/
        Person dest = new Person("1", "张三", 11);
        System.out.println(dest);

        Person source = new Person();
        source.setId("22");
        source.setName("李四");
        System.out.println(source);

        BeanUtils.copyProperties(source, dest);
        System.out.println(dest);
    }
}
