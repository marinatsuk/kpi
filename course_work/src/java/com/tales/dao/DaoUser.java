package com.tales.dao;

import com.tales.model.Tales;
import com.tales.model.User;
import java.util.List;

public interface DaoUser extends AbstractDao<User>  {
    User getByLogin(String login);
    
    User getLiked(List<Tales> liked);
    
    User getLastWatched(List<Tales> lastWatched);
}
