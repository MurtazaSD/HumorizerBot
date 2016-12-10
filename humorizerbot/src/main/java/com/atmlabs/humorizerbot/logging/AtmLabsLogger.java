package com.atmlabs.humorizerbot.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AtmLabsLogger {
	
	private static Logger _log4jLogger;
	private static AtmLabsLogger _AtmLabsLogger;
	
	protected AtmLabsLogger(String name) {
		_log4jLogger = LogManager.getLogger(name);
	}
	
	
	public static AtmLabsLogger getLogger(Class clazz) {
		
		if(_AtmLabsLogger == null) {
			_AtmLabsLogger = new AtmLabsLogger(clazz.getName());
		}

		return _AtmLabsLogger;
	}
	
	public void debug(Object message) {
		_log4jLogger.debug(message);
	}

	public void debug(Object message, Throwable t) {
		_log4jLogger.debug(message, t);
	}

	public void info(Object message) {
		_log4jLogger.info(message);
	}
	public void info(Object message,Throwable t) {
		_log4jLogger.info(message,t);
	}
	
	public void error(Object message) {
		_log4jLogger.error(message);
	}


	public void error(Object message, Throwable t) {
		_log4jLogger.error(message, t);
	}	
}
