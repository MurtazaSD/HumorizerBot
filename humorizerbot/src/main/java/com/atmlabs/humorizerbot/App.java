package com.atmlabs.humorizerbot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atmlabs.humorizerbot.util.SpringApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext applicationContext;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
		System.setProperty("configFileLocation", args[0]);

		loadSpringFramework();
        
		
		
        TelegramBotProcessor processor = SpringApplicationContext.getBean("telegramBotProcessor");
        
        processor.process();
        
    }
    
	private static void loadSpringFramework() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
