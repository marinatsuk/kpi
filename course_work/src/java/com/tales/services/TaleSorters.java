package com.tales.services;

import com.tales.model.Tales;
import java.util.*;
import static java.util.Comparator.*;

public class TaleSorters {
    public static final Map<TalesSortCriteria, Comparator<Tales>> sorters;
    
    static {
        sorters = new HashMap<>();
        sorters.put(TalesSortCriteria.OLD_FIRST, comparing(Tales :: getTaleId));
        sorters.put(TalesSortCriteria.NEW_FIRST, comparing(Tales :: getTaleId, reverseOrder()));
        sorters.put(TalesSortCriteria.BY_TITLE, comparing(Tales :: getTitle));
        sorters.put(TalesSortCriteria.BY_LIKES, comparing(Tales :: getNumberOfLikes, reverseOrder()));
    }
}
