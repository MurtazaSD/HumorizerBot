package com.atmlabs.humorizerbot.models;

import java.util.Date;

public class ChatUpdate {
	public String update_id;
	public Message message;
	
	public class Message {
		public String message_id;
		public From from;
		public Chat chat;
		public String date;
		public String text;
	}
	
	public class From {
		public String id;
		public String first_name;
	}
	
	public class Chat {
		public String id;
		public String first_name;
		public String type;
	}
}
