package com.tales.services;

import com.tales.dao.DaoFactory;
import com.tales.daoImpl.Database;
import com.tales.model.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class TalesServiceImpl implements TalesService {
    DaoFactory daoFactory;
    Database database;
    
    public TalesServiceImpl (DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    @Override
    public Tales getById(Integer taleId) {
        return daoFactory.getTalesDao().get(taleId);
    }
    
    @Override
    public void likeTale(Tales tale, User user) {
        daoFactory.getTalesDao().like(tale, user);
    }

    @Override
    public void unlikeTale(Tales tale, User user) {
        daoFactory.getTalesDao().unlike(tale, user);
    }
    @Override
    public Collection<Tales> getAllTales() {
        return daoFactory.getTalesDao().findAll();
    }
    
    @Override
    public Collection<Tales> getAllTales(TalesSortCriteria talesSortCriteria) {
        Collection<Tales> tales = getAllTales();
        return sort(tales, talesSortCriteria);
    }
    
    private Collection<Tales> sort(Collection<Tales> tales, TalesSortCriteria talesSortCriteria) {
            return tales.stream()
                    .sorted(TaleSorters.sorters.get(talesSortCriteria))
                    .collect(Collectors.toList());
    }
    

    @Override
    public Collection<Tales> search(String text) {
        if (text == null || text.equals(" ")) {
            return getAllTales();
        }
        return daoFactory.getTalesDao().findByText(text);
    }

    @Override
    public Collection<Tales> search(String text, TalesSortCriteria talesSortCriteria) {
        Collection<Tales> tales = search(text);
        return sort(tales, talesSortCriteria);
    }

    @Override
    public void insert(Integer taleId, String author, String title, String description, String link) {
        
    }

    
}

