package com.tales.daoImpl;

import com.tales.model.User;
import com.tales.dao.DaoUser;
import com.tales.model.Tales;
import java.util.List;
import java.util.stream.Stream;

public class DaoUserImpl extends AbstractDaoImpl<User> implements DaoUser {
    
    DaoUserImpl(Database database) {
        super(database.users, User::getUserId, User::setUserId, database);
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(admin -> admin.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getLiked(List<Tales> liked) {
        Stream<Tales> stream;
        stream = liked.stream();
        return (User) database.tales.values()
                .stream();
    };

    @Override
    public User getLastWatched(List<Tales> lastWatched) {
        Stream<Tales> stream;
        stream = lastWatched.stream();
        return (User) database.tales.values()
                .stream();
    }

}
