package com.tales.dao;

import com.tales.model.*;
import java.util.Collection;

public interface DaoTales extends AbstractDao<Tales> {
    void like(Tales tale, User user);
    void unlike(Tales tale, User user);
    Collection<Tales> findByText(String text);
 
}
