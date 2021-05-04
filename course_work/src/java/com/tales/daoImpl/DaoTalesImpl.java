package com.tales.daoImpl;

import com.tales.dao.DaoTales;
import com.tales.model.*;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.*;

class DaoTalesImpl extends AbstractDaoImpl<Tales> implements DaoTales {

    DaoTalesImpl(Database database) {
        super(database.tales, Tales::getTaleId,Tales::setTaleId, database );
    }
    
    @Override
    public void like(Tales tale, User user) {
        tale.getLikers().add(user);
    }

    @Override
    public void unlike(Tales tale, User user) {
        tale.getLikers().remove(user);
    }

    @Override
    public Collection<Tales> findByText(String text) {
        String[] words = text.toLowerCase().split("[,. \\r\\n]+");
        return database.tales.values().stream()
                .filter(tale -> containsWords(tale, words))
                .collect(Collectors.toList());
    }
    private static boolean containsWords(Tales tale, String[] words) {
        String yourText = tale.getTitle() + " " + tale.getDescription();
        yourText = yourText.toLowerCase();
        return Stream.of(words).allMatch(yourText:: contains);
    }

}
