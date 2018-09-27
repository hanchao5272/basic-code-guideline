package pers.hanchao.basiccodeguideline;

import java.util.Date;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/8/13 下午8:03
 */
public class JustDemo {
    public static void main(String[] args) {
        String json = "[{\"title\":\"参与方式\",\"details\":\"在规定时间内，提交表单。\"},{\"title\":\"活动奖励\",\"details\":\"1.一等奖100元\\n2.二等奖20元\"},{\"title\":\"评选规则\",\"details\":\"必须为原创，内容充实，积极向上。\"}]";
        System.out.println(json);

        Date date3 = new Date(2018, 8, 13, 12, 00, 00);
        System.out.println(date3.getTime());
        date3 = new Date(2018, 8, 14, 12, 00, 00);
        System.out.println(date3.getTime());
        date3 = new Date(2018, 8, 15, 12, 00, 00);
        System.out.println(date3.getTime());
        for (int i = 0; i < 15; i++) {
            Long time = new Date(2018 - 1900, 7, 10 + i, 12, 00, 00).getTime();
            System.out.println("2018-8-" + (10 + i - 1) + " 12:00:00  " + "(" + (i + 1) + ", 2, 100" + i + ", 100" + i + "001, 0, " + time + ", 1),");
        }
    }
}
