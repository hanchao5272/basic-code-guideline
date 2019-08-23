package pers.hanchao.basiccodeguideline.kafka.consumer.chat;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.PERSON_LORA;
import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.TOPIC_CHAT_ROOM;

/**
 * <p>聊天室消费者</P>
 *
 * @author hanchao
 */
@Component
public class ChatConsumerLora extends AbstractConsumer {

    /**
     * 聊天者：Lora
     */
    @KafkaListener(id = PERSON_LORA, groupId = PERSON_LORA, topics = {TOPIC_CHAT_ROOM})
    public void listenTopic1(ConsumerRecord<?, ?> record) {
        logRecord(PERSON_LORA, record);
    }
}
