package pers.hanchao.basiccodeguideline.kafka.consumer.chat;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.PERSON_PAUL;
import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.TOPIC_CHAT_ROOM;

/**
 * <p>聊天室消费者</P>
 *
 * @author hanchao
 */
@Component
public class ChatConsumerPaul extends AbstractConsumer {

    /**
     * 聊天者：Paul
     */
    @KafkaListener(id = PERSON_PAUL, groupId = PERSON_PAUL, topics = {TOPIC_CHAT_ROOM})
    public void listenTopic2(ConsumerRecord<?, ?> record) {
        logRecord(PERSON_PAUL, record);
    }
}
