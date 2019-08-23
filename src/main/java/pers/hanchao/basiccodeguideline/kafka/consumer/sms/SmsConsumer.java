package pers.hanchao.basiccodeguideline.kafka.consumer.sms;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

/**
 * <p>短信消费者：Consumer Group只有一个分区</P>
 *
 * @author hanchao
 */
@Component
public class SmsConsumer extends AbstractConsumer {
    /**
     * 对于只有一个分区的topic，不需要分区消费，因为没有意义。
     */
    @KafkaListener(id = KafkaClientDemo.CONSUMER_SMS, topics = {KafkaClientDemo.TOPIC_SMS})
    public void listenTopicForMail(ConsumerRecord<?, ?> record) {
        logRecord(KafkaClientDemo.CONSUMER_SMS, record);
    }
}
