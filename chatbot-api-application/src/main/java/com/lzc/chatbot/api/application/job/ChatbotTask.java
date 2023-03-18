package com.lzc.chatbot.api.application.job;


import com.alibaba.fastjson.JSON;
import com.lzc.chatbot.api.domain.ai.IOpenAI;
import com.lzc.chatbot.api.domain.zsxq.IZsxqApi;
import com.lzc.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.lzc.chatbot.api.domain.zsxq.model.vo.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * 说明： 任务体
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-17 18:35
 */


public class ChatbotTask implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ChatbotTask.class);

    private String groupName;
    private String groupId;
    private String cookie;
    private String openAiKey;
    private boolean silenced;
    private IZsxqApi zsxqApi;
    private IOpenAI openAI;

    public ChatbotTask(String groupName, String groupId, String cookie, String openAiKey, IZsxqApi zsxqApi, IOpenAI openAI, boolean silenced) {
        this.groupName = groupName;
        this.groupId = groupId;
        this.cookie = cookie;
        this.openAiKey = openAiKey;
        this.zsxqApi = zsxqApi;
        this.openAI = openAI;
        this.silenced = silenced;
    }

    @Override
    public void run() {
        try {
            if (new Random().nextBoolean()){
                logger.info("{}随机打烊中",groupName);
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22||hour < 7){
                logger.info("{}随机打烊时间Ai不工作，Ai下班了休息回家了",groupId);
                return;
            }
            //检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId,cookie);
                logger.info("{}检索结果：{}",groupName, JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (null == topics||topics.isEmpty()){
                logger.info("{}本次检索时间",groupName);
                return;
            }

            //Ai回答
            Topics topic = topics.get(topics.size()-1);
            String answer = openAI.doChatGPT(openAiKey,topic.getQuestion().getText().trim());
            //回答问题
            boolean status = zsxqApi.answer(groupId, cookie, answer, topic.getTopic_id(), silenced);
                logger.info("{}编号： 问题：{} 状态：{} 回答：{}",groupName, topic.getTopic_id(),
                        topic.getQuestion().getText(), answer, status);
            } catch (IOException e) {
                logger.error("{}自动回答问题异常",groupName, e);
        }
    }
}
