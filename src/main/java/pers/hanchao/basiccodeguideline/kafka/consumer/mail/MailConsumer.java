package pers.hanchao.basiccodeguideline.kafka.consumer.mail;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

/**
 * <p>邮件-3个分区-Consumer Group只有1个Consumer</P>
 *
 * @author hanchao
 */
@Component
public class MailConsumer extends AbstractConsumer {
    /**
     * 无视分区进行消费,消费所有分区
     */
    @KafkaListener(id = KafkaClientDemo.CONSUMER_MAIL, groupId = KafkaClientDemo.CONSUMER_GROUP_MAIL_1, topics = {KafkaClientDemo.TOPIC_MAIL})
    public void listenTopicForSms0(ConsumerRecord<?, ?> record) {
        logRecord(KafkaClientDemo.CONSUMER_MAIL, record);
    }
}
