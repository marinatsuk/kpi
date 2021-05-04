
package com.tales.services;

import com.tales.dao.DaoFactory;
import com.tales.model.Tales;
import com.tales.model.User;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class UserServiceImpl implements UserService {
    DaoFactory daoFactory;
    UnaryOperator<String> passwordHasher;
    
    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passwordHasher ) {
        this.daoFactory = daoFactory;
        this.passwordHasher = passwordHasher;
    }

    public UserServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }
    
    @Override
    public boolean checkPassword (User user, String password) {
        return user.getPasswordHash().equals(passwordHasher.apply(password));
    }

    @Override
    public User getLiked(List<Tales> liked) {
        return daoFactory.getUserDao().getLiked(liked);
    }

    @Override
    public User getLastWatched(List<Tales> lastWatched) {
        return daoFactory.getUserDao().getLastWatched(lastWatched);
    }
}
