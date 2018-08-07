package pers.hanchao.basiccodeguideline.substr;

/**
 * <p>Description: 字符串截取示例：String类型的编号自增一</P>
 *
 * @author hanchao
 * @date 2018/7/5 上午10:54
 */
public class SubstringDemo {
    public static void main(String[] args) {
//        String maxId = "T0101";
        String maxId = "T0111";

        //获取前三位作为前缀
        String prefix = maxId.substring(0,3);
        System.out.println(prefix);

        //获取后两位，并进行自增
        String suffix1 = maxId.substring(3,5);
        System.out.println(suffix1);

        Integer suffix = Integer.parseInt(maxId.substring(3,5)) + 1;
        System.out.println(suffix);

        String nextId = suffix > 9 ? prefix + suffix : prefix + "0" + suffix;
        System.out.println(maxId + " ==> " + nextId);
    }
}
