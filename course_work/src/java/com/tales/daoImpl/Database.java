
package com.tales.daoImpl;

import com.tales.dao.DaoFactory;
import java.util.Map;
import java.util.TreeMap;
import com.tales.model.*;


public class Database {
    Map<Integer, Tales> tales;
    Map<Integer, User> users;
    
    public Database() {
        tales = new TreeMap<>();
        users = new TreeMap<>();   
    }
    
    public DaoFactory getDaoFactory() {
        return new DaoFactoryImpl(this);
    }
}
