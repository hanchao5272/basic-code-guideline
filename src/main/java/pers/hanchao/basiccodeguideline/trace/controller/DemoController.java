package pers.hanchao.basiccodeguideline.trace.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></P>
 *
 * @author hanchao
 */
@RestController
public class DemoController {
    private final Logger logger = Logger.getLogger(DemoController.class);

    @GetMapping("/demo/by-name")
    public String demo(String name) {
        logger.info("name:" + name);
        return name;
    }
}
