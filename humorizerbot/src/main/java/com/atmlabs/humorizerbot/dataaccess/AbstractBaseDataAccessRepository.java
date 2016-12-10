package com.atmlabs.humorizerbot.dataaccess;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atmlabs.humorizerbot.logging.AtmLabsLogger;
import com.atmlabs.humorizerbot.repositories.BotRepositories;


@Repository
public abstract class AbstractBaseDataAccessRepository implements IBaseDataAccessRepositoryInterface{
	
	protected static AtmLabsLogger _log = AtmLabsLogger.getLogger(BotRepositories.class);

	/**
	 * Persist the passed object into the database
	 */
	@Transactional(value="transactionManager")
	public boolean save(EntityManager em, Object object) {

		try {
		// Persist the passed object
			em.persist(object);
		} catch (Exception e) {
			_log.error(this, e);
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
