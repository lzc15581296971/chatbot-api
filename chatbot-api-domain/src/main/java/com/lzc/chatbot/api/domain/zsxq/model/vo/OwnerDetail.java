package com.lzc.chatbot.api.domain.zsxq.model.vo;

/**
 * 说明： TODO
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 15:04
 */
public class OwnerDetail {

    private int questions_count;

    private String join_time;

    public void setQuestions_count(int questions_count){
        this.questions_count = questions_count;
    }
    public int getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }

}