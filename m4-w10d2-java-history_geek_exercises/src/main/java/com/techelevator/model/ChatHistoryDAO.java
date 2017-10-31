package com.techelevator.model;

import java.util.List;

public interface ChatHistoryDAO {

    /**
     *  Retrieves the most recent chat messages
     * @param limit - Amount of most recent messages to receive (e.g. last 10)
     * @return
     */
    List<ChatMessage> getChatMessages(int limit);

    
    /**
     *  Saves a new chat message
     * @param message
     */
    void saveChatMessage(ChatMessage message);

}
