package com.atmlabs.humorizerbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmlabs.humorizerbot.database.entities.MessageEntity;
import com.atmlabs.humorizerbot.logging.AtmLabsLogger;
import com.atmlabs.humorizerbot.models.ChatUpdate;
import com.atmlabs.humorizerbot.models.ChatUpdateContainer;
import com.atmlabs.humorizerbot.models.SendMessage;
import com.atmlabs.humorizerbot.repositories.BotRepositories;
import com.google.gson.Gson;


@Service
public class TelegramBotProcessor {
	
	protected static AtmLabsLogger _log = AtmLabsLogger.getLogger(TelegramBotProcessor.class);

	@Autowired
	BotRepositories botRepo;
	
	public void process() {
        
		TelegramBotClient telegramBotClient = new TelegramBotClient();
        
        String sUpdates = telegramBotClient.getUpdates();
        
        Gson gson = new Gson();
        
        ChatUpdateContainer chatUpdateContainer = gson.fromJson(sUpdates, ChatUpdateContainer.class);
        
        System.out.println(chatUpdateContainer.result.get(0).message.text);
        
        SendMessage sendMessage = new SendMessage();
        
       
        for(ChatUpdate chatUpdate : chatUpdateContainer.result) {
            _log.debug(chatUpdate.message.text);

        	MessageEntity message = new MessageEntity();
        	
       	
        	message.setText(chatUpdate.message.text);
        	java.util.Date currentDt = new java.util.Date();
        	message.setTstamp(new java.sql.Date(currentDt.getTime()));
        	
        	
        	botRepo.save(message);
        	
        	sendMessage.chat_id = chatUpdate.message.chat.id;
        	sendMessage.text = "I am listening !!";
            telegramBotClient.sendMessage(sendMessage);
        }
        		
        		
        
        
	}

}
