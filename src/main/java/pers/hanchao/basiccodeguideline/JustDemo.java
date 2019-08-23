package pers.hanchao.basiccodeguideline;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/8/13 下午8:03
 */
public class JustDemo {
    public static void main(String[] args) throws InterruptedException {
        String sql11 = "孩子总爱哭，让人头疼还没办法？恭喜，这孩子可能是\\'报恩\\'的'";
        String sql22 = "{\\\"type\\\":\\\"0\\\",\\\"images\\\":[{\\\"url\\\":\\\"http://si1.go2yd.com/get-image/0T0kJlgPDt2\\\",\\\"source\\\":\\\"http://si1.go2yd.com/get-image/0T0kJlgPDt2\\\"}]}";
        String sql33 = "孩子总爱哭，让人头疼还没办法？恭喜，这孩子可能是'报恩'的";
        String sql44 = "{\"type\":\"0\",\"images\":[{\"url\":\"http://si1.go2yd.com/get-image/0T0kJlgPDt2\",\"source\":\"http://si1.go2yd.com/get-image/0T0kJlgPDt2\"}]}";

        System.out.println(sql11);
        System.out.println(sql22);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(sql33);
        System.out.println(sql44);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(addSlashes(sql33));
        System.out.println(addSlashes(sql44));
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\\");
        System.out.println(addSlashes("\\"));
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("NULL");
        System.out.println(addSlashes("NULL"));


        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
        fucn();

        System.out.println("------------------------------------------------------------------------------------------");
    }

    /**
     * 参考PHP的addSlashes()方法，对单引号（'）、双引号（"）、反斜杠（\）、NULL进行转义
     */
    private static String addSlashes(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\")
                .replaceAll("'", "\\\\'")
                .replaceAll("\"", "\\\\\"")
                .replaceAll("NULL", "\\\\NULL");
    }

    public static void fucn() {
        List<Long> list = Lists.newArrayList(0b0L, 0b1L, 0b11L, 0b100L, 0b101L, 0b111L, 0b1000L, 0b1100L, 0b10001L, 0b10101L);

        System.out.print("&3 = 1>>>>>");
        for (int i = 0; i < list.size(); i++) {

            if ((list.get(i) & 3L) == 1L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&3 = 3>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 3L) == 3L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&1 = 1>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 1L) == 1L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&17 = 17>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 17L) == 17L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&2 = 2>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 2L) == 2L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&2 != 2>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 2L) != 2L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&2 == 1>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 2L) == 1L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&3 == 1>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 3L) == 1L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&17 == 1>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 17L) == 1L) {
                System.out.print(" " + list.get(i));
            }
        }

        System.out.println();
        System.out.print("&4 == 4>>>>>");
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) & 4L) == 4L) {
                System.out.print(" " + list.get(i));
            }
        }


        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(17 | 17);
        System.out.println(5 | 17);
    }


}
