package pers.hanchao.basiccodeguideline.optional;

import java.util.Optional;

/**
 * <p>Description: Optional示例：of、ofNullable、orElse、get</P>
 *
 * @author hanchao
 * @date 2018/7/3 下午8:25
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Integer page = null;
        Integer size = 100;

        //通过ofNullable和orElse能够设置当指定对象为null时的默认值
        int pageNum = Optional.ofNullable(page).orElse(1);
        System.out.println(pageNum);

        //通过of获取Optional的值
        Optional<Integer> pageSize = Optional.of(size);
        //通过get方法获取实际的对象
        System.out.println(pageSize.get());
    }
}
