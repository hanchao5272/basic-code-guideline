package pers.hanchao.basiccodeguideline.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>生产者</P>
 *
 * @author hanchao
 */
@Slf4j
@RestController
public class ProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息
     */
    @GetMapping("/kafka/batch-send")
    public boolean batchSendMessage(@RequestParam(required = false) String producer,
                                    @RequestParam String topic,
                                    @RequestParam(required = false) Integer partition,
                                    @RequestParam(required = false) String key,
                                    @RequestParam String value,
                                    @RequestParam(required = false) Integer batch) {
        producer = Objects.isNull(producer) ? "Message Producer" : producer;
        batch = Objects.isNull(batch) ? 1 : batch;

        for (int i = 0; i < batch; i++) {
            sendMessage(producer, topic, partition, key, value + i);
        }
        return true;
    }

    /**
     * 发送消息
     */
    private void sendMessage(String producer, String topic, Integer partition, String key, String value) {
//        log.info("======>>> " + producer + ": topic={}, [partition={}], [key={}], value={}", topic, partition, key, value);
        log.info("{}--发送消息:{}", producer, value);
        if (Objects.nonNull(partition)) {
            if (StringUtils.isNotEmpty(key)) {
                kafkaTemplate.send(topic, partition, key, value);
            } else {
                kafkaTemplate.send(topic, partition, null, value);
            }
        } else {
            if (StringUtils.isNotEmpty(key)) {
                kafkaTemplate.send(topic, key, value);
            } else {
                kafkaTemplate.send(topic, value);
            }
        }
    }
}
