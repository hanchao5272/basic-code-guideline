package pers.hanchao.basiccodeguideline.kafka.consumer.mail;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.*;

/**
 * <p>邮件-3个分区-Consumer数量大于分区数量</P>
 *
 * @author hanchao
 */
@Component
public class MailMultiConsumer extends AbstractConsumer {
    /**
     * 如果Consumer-Group组中的Consumer数量多于分区数量，则在服务稳定运行期间，会有Consumer永远无法消费消息
     */
    @KafkaListener(id = CONSUMER_MAIL_MULTI_0, groupId = CONSUMER_GROUP_MAIL_3, topics = {TOPIC_MAIL})
    public void listenTopic0(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_MULTI_0, record);
    }

    @KafkaListener(id = CONSUMER_MAIL_MULTI_1, groupId = CONSUMER_GROUP_MAIL_3, topics = {TOPIC_MAIL})
    public void listenTopic1(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_MULTI_1, record);
    }

    @KafkaListener(id = CONSUMER_MAIL_MULTI_2, groupId = CONSUMER_GROUP_MAIL_3, topics = {TOPIC_MAIL})
    public void listenTopic2(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_MULTI_2, record);
    }

    @KafkaListener(id = CONSUMER_MAIL_MULTI_3, groupId = CONSUMER_GROUP_MAIL_3, topics = {TOPIC_MAIL})
    public void listenTopic3(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_MULTI_3, record);
    }
}
