package pers.hanchao.basiccodeguideline.fail;

/**
 * <p>主要的外部服务</P>
 *
 * @author hanchao
 */
public class MajorExternalService {

    public static boolean saveOrder() {
        return true;
    }

    public static boolean saveLog() {
        return false;
    }

    public static Object getGoodsInfo() {
        return null;
    }
}
