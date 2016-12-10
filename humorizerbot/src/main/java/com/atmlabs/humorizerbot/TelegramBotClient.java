package com.atmlabs.humorizerbot;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.atmlabs.humorizerbot.models.SendMessage;
import com.atmlabs.humorizerbot.util.WebUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class TelegramBotClient {
	private static String TelegramBotToken = "310866810:AAGI6a9dYEh7LXaXsyV7N_Uls5W6R5mboJQ";
	private static String TelegramBotBaseURL = "https://api.telegram.org/bot";
	
	public String getUpdates() {
		
		String sURL = TelegramBotBaseURL + TelegramBotToken + "/getUpdates";
		
		String sUpdates = WebUtil.makeHttpCall(sURL, HttpMethod.GET, null);
		
		System.out.println(sUpdates);
		
		return sUpdates;
	}
	
	public String sendMessage(SendMessage sendMessage) {
		String sURL = TelegramBotBaseURL + TelegramBotToken + "/sendMessage";
		
		Gson gson = new Gson();
		
		String sSendMessageJson = gson.toJson(sendMessage, SendMessage.class);
		
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(sSendMessageJson, headers);
		
		String sMessage = WebUtil.makeHttpCall(sURL, HttpMethod.POST, entity);
		
		return sMessage;

	}
	
	
	
}
