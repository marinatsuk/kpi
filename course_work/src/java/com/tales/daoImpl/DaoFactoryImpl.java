package com.tales.daoImpl;

import com.tales.dao.*;

public class DaoFactoryImpl implements DaoFactory {
    Database database;
    DaoUser userDao;
    DaoTalesImpl talesDao;
    
    DaoFactoryImpl (Database database) {
        this.database = database;
        talesDao = new DaoTalesImpl (database);
        userDao = new DaoUserImpl(database) {};
    }
    @Override
    public DaoUser getUserDao() {
        return userDao;
    }

    @Override
    public DaoTales getTalesDao() {
        return talesDao;
    }
    
    
}
