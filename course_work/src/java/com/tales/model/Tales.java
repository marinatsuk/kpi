
package com.tales.model;


import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Tales {
    private Integer taleId;
    private String author;
    private String title;
    private String description;
    private String link;
    private Set<User> likers;
    private Instant instant;

    public Tales(Integer taleId, String author, String title, String description, String link) {
        this.taleId = taleId;
        this.author = author;
        this.title = title;
        this.description = description;
        this.link = link;
    }
    
    public Tales(Integer taleId, String author, String title, String description, String link, Instant instant) {
        this.taleId = taleId;
        this.author = author;
        this.title = title;
        this.description = description;
        this.link = link;
        this.instant = instant;
        likers = new HashSet<>();
    }
    
    public Integer getTaleId() {
        return taleId;
    }

    public void setTaleId(Integer taleId) {
        this.taleId = taleId;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
     public Set<User> getLikers() {
        return likers;
    }

    public void setLikers(Set<User> likers) {
        this.likers = likers;
    }
    
      public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
    
    public int getNumberOfLikes() {
        return likers.size();
    }
    
}

