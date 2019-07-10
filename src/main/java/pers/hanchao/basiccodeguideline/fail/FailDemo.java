package pers.hanchao.basiccodeguideline.fail;

/**
 * <p>容错机制:failFast,failSafe,failOver,failBack</P>
 *
 * @author hanchao
 */
public class FailDemo {


    /**
     * fail-fast: 快速故障
     */
    public Object failFast() {
        //保存订单
        boolean result = MajorExternalService.saveOrder();

        if (result) {
            return "success";
        } else {
            //fail-fast
            throw new IllegalStateException("下单失败!");
        }
    }

    /**
     * fail-safe: 故障安全
     */
    public Object failSafe() {
        //写入日志
        boolean result = MajorExternalService.saveLog();

        if (result) {
            return "success";
        } else {
            //fail-safe
            return "failed";
        }
    }

    /**
     * 默认情况下使用主要外部服务MajorExternalService
     */
    private static boolean isMajorOK = true;

    /**
     * fail-over: 故障切换
     */
    public Object failOver() {
        //读取商品信息
        Object goodsInfo;

        //默认情况下使用主要外部服务
        if (isMajorOK) {
            try {
                goodsInfo = MajorExternalService.getGoodsInfo();
            } catch (Exception e) {
                //fail-over: 调用主要外部服务发生故障，则切换为备用外部服务
                isMajorOK = false;
                goodsInfo = MinorExternalService.getGoodsInfo();
            }
        } else {
            //
            goodsInfo = MinorExternalService.getGoodsInfo();
        }

        return goodsInfo;
    }

    /**
     * fail-back: 故障恢复
     */
    public void failBack() {
        //一直在监测主要外部服务的状态
        while (true) {
            //通过某些方法得知主要外部服务已经恢复了
            if (confirmMajorIsOk()) {
                //fail-back
                isMajorOK = true;
                break;
            }
        }
    }

    private boolean confirmMajorIsOk() {
        return true;
    }
}
