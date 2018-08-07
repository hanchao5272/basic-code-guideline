package pers.hanchao.basiccodeguideline.percent;

import java.text.DecimalFormat;

/**
 * <p>Description: Long型计算百分比、百分比格式化</P>
 *
 * @author hanchao
 * @date 2018/7/4 上午11:41
 */
public class LongPercentAndFormatDemo {
    public static void main(String[] args) {
        //Long型计算百分比
        Long count = 2L;
        Long total = 10L;
        Float percent = (float) count / (float)total;
        System.out.println(percent);

        //百分比格式化
        System.out.println(new DecimalFormat("#.00%").format(percent));
        //#：没有则为空
        System.out.println(new DecimalFormat("#.00%").format(0F));
        System.out.println(new DecimalFormat("#.00%").format(1F));
        //0：没有则补0
        System.out.println(new DecimalFormat("0.00%").format(0F));
        System.out.println(new DecimalFormat("0.00%").format(1F));
    }
}
