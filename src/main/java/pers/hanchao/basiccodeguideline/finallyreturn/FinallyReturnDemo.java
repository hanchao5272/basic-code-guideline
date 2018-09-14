package pers.hanchao.basiccodeguideline.finallyreturn;

/**
 * <p>Description：异常处理的finally中的return </P>
 *
 * @author hanchao
 * @date 2018/9/14 下午3:56
 */
public class FinallyReturnDemo {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(get(1));
        System.out.println(get(2));
    }

    public static int get(int i) {
        try {
            if (i > 1) {
                return 0;
            } else {
                throw new IllegalAccessException();
            }
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }
}
