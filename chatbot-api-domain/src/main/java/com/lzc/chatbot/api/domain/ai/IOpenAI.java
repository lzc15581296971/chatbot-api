package com.lzc.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * 说明： TODO
 *
 * @author 小智
 * @version 1.0
 * @date 2023-03-16 16:08
 */
public interface IOpenAI {

        String doChatGPT(String openAiKey, String question) throws IOException;

}