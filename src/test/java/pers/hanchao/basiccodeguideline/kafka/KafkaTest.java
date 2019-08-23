package pers.hanchao.basiccodeguideline.kafka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static pers.hanchao.basiccodeguideline.kafka.KafkaClientDemo.*;

/**
 * <p>kafka测试</P>
 *
 * @author hanchao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {
    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 保证消息被处理完
     */
    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
    }

    /**
     * http get 请求 test 的简单封装
     */
    public void simpleGet(String url) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
    }

    /**
     * 短信，一个分区，一个Consumer
     * producer 无需传参 partition和key
     * consumer 无需指定group
     */
    @Test
    public void testForSimple() throws Exception {
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&value=hello&batch=5");
    }

    /**
     * 指定分区进行分发
     */
    @Test
    public void testForPartition() throws Exception {
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&partition=0&value=hello&batch=1");
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&partition=1&value=hello&batch=1");
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&partition=2&value=hello&batch=1");
    }

    /**
     * 指定key进行分发
     * key的作用是为消息选择存储分区，key可以为空。
     * 当指定key且不为空的时候，kafka是根据key的hash值与分区数取模来决定数据存储到那个分区。
     * 当key=null时，kafka是先从缓存中取分区号，然后判断缓存的值是否为空，如果不为空，就将消息存到这个分区，否则随机选择一个分区进行存储，并将分区号缓存起来，供下次使用。
     */
    @Test
    public void testForKey() throws Exception {
        // 9=2 10=1 11=0
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&key=9&value=hello&batch=1");
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&key=10&value=hello&batch=1");
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&key=11&value=hello&batch=1");
    }

    /**
     * 如果Consumer-Group中只有1个Consumer，则相当于发布订阅
     * 如果Consumer-Group中只有多个个Consumer，则相当于p2p
     * 如果Consumer-Group组中的Consumer数量多于分区数量，则在服务稳定运行期间，会有Consumer永远无法消费消息
     */
    @Test
    public void testForMultiConsumer() throws Exception {
        simpleGet("/kafka/batch-send?topic=" + TOPIC_MAIL + "&partition=2&value=hello&batch=10000");
    }

    /**
     * 聊天室
     */
    @Test
    public void testForChatRoom() throws Exception {
        simpleGet("/kafka/batch-send?topic=" + TOPIC_CHAT_ROOM + "&producer=" + PERSON_JACK + "&value=" + "新人报到，多多指教！");

        Thread.sleep(1000);
        simpleGet("/kafka/batch-send?topic=" + TOPIC_CHAT_ROOM + "&producer=" + PERSON_LORA + "&value=" + "欢迎欢迎！！！");

        Thread.sleep(1000);
        simpleGet("/kafka/batch-send?topic=" + TOPIC_CHAT_ROOM + "&producer=" + PERSON_PAUL + "&value=" + "欢迎！另：入群请改名，谢谢！");
    }
}
