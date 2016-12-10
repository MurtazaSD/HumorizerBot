package com.atmlabs.humorizerbot.dataaccess;

import javax.persistence.EntityManager;

public interface IBaseDataAccessRepositoryInterface {
	public boolean save(EntityManager em, Object object);

}
