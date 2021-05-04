package com.tales.services;

import com.tales.model.*;
import java.util.List;

public interface UserService {
    User getByLogin(String login);
    
    User getLiked(List<Tales> liked);
    
    User getLastWatched(List<Tales> lastWatched);
    
    boolean checkPassword (User user, String passwordHash);
}
