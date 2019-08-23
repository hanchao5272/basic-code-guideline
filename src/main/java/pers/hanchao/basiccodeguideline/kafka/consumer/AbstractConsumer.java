package pers.hanchao.basiccodeguideline.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * <p></P>
 *
 * @author hanchao
 */
@Slf4j
public abstract class AbstractConsumer {
    /**
     * 打印消息
     */
    public void logRecord(String name, ConsumerRecord<?, ?> record) {
//        log.info("<<<------ " + name + " : topic={}, [partition={}], [key={}], value={}, offset={}",record.topic(), record.partition(), record.key(), record.value(), record.offset());
        log.info("{}--收到消息:{}", name, record.value());
    }
}
