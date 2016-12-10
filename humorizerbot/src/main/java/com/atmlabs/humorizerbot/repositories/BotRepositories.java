package com.atmlabs.humorizerbot.repositories;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atmlabs.humorizerbot.dataaccess.AbstractBaseDataAccessRepository;
import com.atmlabs.humorizerbot.logging.AtmLabsLogger;

@Component
@MappedSuperclass
public class BotRepositories extends AbstractBaseDataAccessRepository{
	
	private static AtmLabsLogger _log = AtmLabsLogger.getLogger(BotRepositories.class);
	
	@PersistenceContext(unitName="humorizerbotPU")
	@Qualifier(value="emf")
	protected EntityManager em;
	
	@Transactional(value="transactionManager")
	public void save(Object object) {
		save(em, object);
	}

}
