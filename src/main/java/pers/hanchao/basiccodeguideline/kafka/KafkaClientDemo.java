package pers.hanchao.basiccodeguideline.kafka;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.TopicPartitionInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * <p></P>
 *
 * @author hanchao
 */
@Slf4j
public class KafkaClientDemo {
    /**
     * 聊天室   3分区
     */
    public static final String TOPIC_CHAT_ROOM = "topic-hc-chat-room";
    public static final String PERSON_LORA = "Lora";
    public static final String PERSON_JACK = "Jack";
    public static final String PERSON_PAUL = "Paul";

    /**
     * 邮件     3分区
     */
    public static final String TOPIC_MAIL = "topic-hc-mail";

    public static final String CONSUMER_GROUP_MAIL_1 = "MailConsumer-Group-1";
    public static final String CONSUMER_MAIL = "MailConsumer-ALL";

    public static final String CONSUMER_GROUP_MAIL_2 = "MailConsumer-Group-2";
    public static final String CONSUMER_MAIL_PARTITION_0 = "MailConsumer-P0";
    public static final String CONSUMER_MAIL_PARTITION_12 = "MailConsumer-P1,P2";

    public static final String CONSUMER_GROUP_MAIL_3 = "MailConsumer-Group-3";
    public static final String CONSUMER_MAIL_MULTI_0 = "MailConsumer-M0";
    public static final String CONSUMER_MAIL_MULTI_1 = "MailConsumer-M1";
    public static final String CONSUMER_MAIL_MULTI_2 = "MailConsumer-M2";
    public static final String CONSUMER_MAIL_MULTI_3 = "MailConsumer-M3";

    /**
     * 短信     1分区
     */
    public static final String TOPIC_SMS = "topic-hc-sms";
    public static final String CONSUMER_SMS = "SmsConsumer";

    /**
     * 显示、创建、删除topic
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获取kafka管理客户端
        AdminClient client = getKafkaAdminClient();

        //查询全部topic
        Collection<String> topics = getAllTopic(client);

        //创建topic：副本数不能超过broker数量
        client.createTopics(Lists.newArrayList(
                //聊天室   3分区
                new NewTopic(TOPIC_CHAT_ROOM, 3, (short) 1),
                //邮件     3分区
                new NewTopic(TOPIC_MAIL, 3, (short) 1),
                //短信     1分区
                new NewTopic(TOPIC_SMS, 1, (short) 1)
        ));

        //查询topic详情
        List<String> wantedTopicList = Lists.newArrayList(TOPIC_CHAT_ROOM, TOPIC_MAIL, TOPIC_SMS);
        showTopicInfo(client, topics, wantedTopicList);

        //删除topic：想要修改topic的配置如分区等需要删掉重建
        client.deleteTopics(Lists.newArrayList("topic-send-sms","topic-send-mail"));
    }

    /**
     * 获取kafka管理客户端
     */
    private static AdminClient getKafkaAdminClient() {
        Map<String, Object> props = new HashMap<>(1);
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.126.153.155:9092");
        return KafkaAdminClient.create(props);
    }

    /**
     * 显示指定topic的信息
     */
    private static void showTopicInfo(AdminClient client, Collection<String> topics, List<String> wantedTopicList) throws InterruptedException, ExecutionException {
        client.describeTopics(topics).all().get().forEach((topic, description) -> {
            if (wantedTopicList.contains(topic)) {
                log.info("==== Topic {} Begin ====", topic);
                for (TopicPartitionInfo partition : description.partitions()) {
                    log.info(partition.toString());
                }
                log.info("==== Topic {} End ====", topic);
            }
        });
    }

    /**
     * 获取全部topic名称
     */
    private static Collection<String> getAllTopic(AdminClient client) throws InterruptedException, ExecutionException {
        return client.listTopics().listings().get().stream().map(TopicListing::name).collect(Collectors.toList());
    }
}
