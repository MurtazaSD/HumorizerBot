package com.atmlabs.humorizerbot.database;

import org.hibernate.dialect.MySQL5Dialect;

public class HumorizerMySQLDialect extends MySQL5Dialect {

	 public HumorizerMySQLDialect() {
	        //registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.TEXT.getName());
	        //registerHibernateType(Types.NVARCHAR, StandardBasicTypes.TEXT.getName());
	    }
}
