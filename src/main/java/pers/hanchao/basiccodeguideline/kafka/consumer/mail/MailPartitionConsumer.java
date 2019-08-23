package pers.hanchao.basiccodeguideline.kafka.consumer.mail;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.*;

/**
 * <p>邮件-3个分区-分区消费</P>
 *
 * @author hanchao
 */
@Component
public class MailPartitionConsumer extends AbstractConsumer {
    /**
     * 分区消费能够加快消息消费速度
     * 此Consumer只消费分区0的数据
     */
    @KafkaListener(id = CONSUMER_MAIL_PARTITION_0, groupId = CONSUMER_GROUP_MAIL_2, topicPattern = TOPIC_MAIL)
    public void listenTopicForSms0(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_PARTITION_0, record);
    }

    /**
     * 分区消费能够加快消息消费速度
     * 此Consumer消费分区1的数据
     */
    @KafkaListener(id = CONSUMER_MAIL_PARTITION_12, groupId = CONSUMER_GROUP_MAIL_2, topicPattern = TOPIC_MAIL)
    public void listenTopicForSms1(ConsumerRecord<?, ?> record) {
        logRecord(CONSUMER_MAIL_PARTITION_12, record);
    }
}
