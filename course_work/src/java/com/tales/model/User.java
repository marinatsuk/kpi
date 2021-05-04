/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tales.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author serg
 */
public class User {
    private Integer userId;
    private String login;
    private String passwordHash;
    private String name;
    private boolean isAdmin;
    private List<Tales> liked;
    private List<Tales> lastWatched;


    public User(Integer userId, String name, String login, String passwordHash) {
        this.userId = userId;
        this.login = login;
        this.passwordHash = passwordHash;
        this.name = name;
        
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
        
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public boolean isAdmin() {
        return isAdmin;
    }
    
    public void promoteToAdmin() {
        isAdmin = true;
    }
    
    public List<Tales> getLiked() {
        return liked;
    }

    public void setLiked(List<Tales> liked) {
        this.liked = liked;
    }
    
    public List<Tales> getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(List<Tales> lastWatched) {
        this.lastWatched = lastWatched;
    }
    // Used for HashSet in Tales.likers
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    // Used for HashSet in Tales.likers
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
            
        if (getClass() != obj.getClass()) return false;
            
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }
}
