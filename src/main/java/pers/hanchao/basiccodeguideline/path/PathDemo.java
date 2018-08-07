package pers.hanchao.basiccodeguideline.path;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * <p>Description: 路径示例-通过ResourceUtils获取路径 </P>
 *
 * @author hanchao
 * @date 2018/7/6 下午1:58
 */
public class PathDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //获取根目录
        System.out.println("classpath: " + ResourceUtils.getURL("classpath:").getPath());
        System.out.println("classpath: " + ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath());

        //获取根目录下指定目录
        System.out.println("classpath:/template/ " + ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "template" + File.separator).getPath());
    }
}
