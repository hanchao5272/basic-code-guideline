package pers.hanchao.basiccodeguideline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 使用嵌入式容器时，可以使用@ServletComponentScan启用@WebServlet，@ WebFilter和@WebListener注释类的自动注册。
 */
@ServletComponentScan(basePackages = "pers.hanchao.basiccodeguideline.trace.filter")
@SpringBootApplication
public class BasicCodeGuidelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicCodeGuidelineApplication.class, args);
    }
}
