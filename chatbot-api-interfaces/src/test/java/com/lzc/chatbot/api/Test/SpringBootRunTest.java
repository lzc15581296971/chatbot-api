package com.lzc.chatbot.api.Test;

import com.alibaba.fastjson.JSON;
import com.lzc.chatbot.api.domain.ai.IOpenAI;
import com.lzc.chatbot.api.domain.zsxq.IZsxqApi;
import com.lzc.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.lzc.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 说明： TODO
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 22:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.group01.groupId}")
    private String groupId;
    @Value("${chatbot-api.group01.cookie}")
    private String cookie;
    @Value("${chatbot-api.group01.openAiKey}")
    private String openAiKey;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);

            // 回答问题
            zsxqApi.answer(groupId, cookie, topicId, openAI.doChatGPT(openAiKey, text), false);
        }
    }

    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
        logger.info("测试结果：{}", response);
    }

}
