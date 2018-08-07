package pers.hanchao.basiccodeguideline.date8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * <p>Description: Java8时间处理示例：Long与时间转换、时间格式化</P>
 *
 * @author hanchao
 * @date 2018/7/4 下午3:54
 */
public class Java8TimeDemo {
    public static void main(String[] args) {
        //获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println("date:   " + date + "\n");

        //Long转时间
        Long now = System.currentTimeMillis();
        System.out.println("long:   " + now);
        Instant instant = Instant.ofEpochMilli(now);
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId);
        System.out.println("time:   " + localDateTime + "\n");

        //格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String time = localDateTime.format(formatter);
        System.out.println("format: " + time + "\n");

        //Long转时间+格式化
        Long now1 = System.currentTimeMillis();
        String time1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(now1),ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println("format: " + time1);
    }
}
