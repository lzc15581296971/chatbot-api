package com.lzc.chatbot.api.domain.zsxq.model.res;

import com.lzc.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * 说明： TODO
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 15:49
 */
public class RespData {

    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
