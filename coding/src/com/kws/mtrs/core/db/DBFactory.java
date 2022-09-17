package com.kws.mtrs.core.db;

import com.kws.mtrs.core.dao.AbstractDataAccessObject;




public class DBFactory
{
	public DBFactory()
	{
		new AbstractDataAccessObject().getConnection();
	}
}
