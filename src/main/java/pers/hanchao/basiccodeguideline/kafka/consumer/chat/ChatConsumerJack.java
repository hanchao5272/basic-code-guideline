package pers.hanchao.basiccodeguideline.kafka.consumer.chat;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.hanchao.basiccodeguideline.kafka.consumer.AbstractConsumer;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.PERSON_JACK;
import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.TOPIC_CHAT_ROOM;

/**
 * <p>聊天室消费者</P>
 *
 * @author hanchao
 */
@Component
public class ChatConsumerJack extends AbstractConsumer {
    /**
     * 聊天者：Jack
     * group不设置则与id相同
     */
    @KafkaListener(id = PERSON_JACK, groupId = PERSON_JACK, topics = {TOPIC_CHAT_ROOM})
    public void listenTopic0(ConsumerRecord<?, ?> record) {
        logRecord(PERSON_JACK, record);
    }
}
