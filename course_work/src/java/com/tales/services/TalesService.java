package com.tales.services;

import com.tales.model.Tales;
import com.tales.model.User;
import java.util.Collection;


public interface TalesService {
        Collection<Tales> getAllTales();
        Collection<Tales> getAllTales(TalesSortCriteria talesSortCriteria);
        Collection<Tales> search(String text);
        Collection<Tales> search(String text, TalesSortCriteria talesSortCriteria);
        
        Tales getById(Integer taleId);
        
        void likeTale(Tales tale, User user);
        void unlikeTale(Tales tale, User user);
        
        void insert(Integer taleId, String author, String title, String description, String link);
        
}
