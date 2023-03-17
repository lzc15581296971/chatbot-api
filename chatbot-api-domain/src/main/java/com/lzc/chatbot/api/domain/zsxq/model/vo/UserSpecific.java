package com.lzc.chatbot.api.domain.zsxq.model.vo;

/**
 * 说明： TODO
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 15:06
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }

}