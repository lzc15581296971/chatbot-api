package com.lzc.chatbot.api.domain.zsxq.model.aggregates;

import com.lzc.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * 说明： 未回答问题的聚合信息
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 15:32
 */
public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }

    public RespData getResp_data() {
        return resp_data;
    }
}
