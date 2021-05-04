package com.tales.daoImpl;

import com.tales.model.*;
import java.util.*;

public class TestData {
    public static void generateTestData(Database database) {
        database.users.clear();
        database.tales.clear();
        
        User user1 = new User(1, "Connor", "connor@tale.com", "k5connor");
        User user2 = new User(2, "Laurel", "laurel@tale.com", "k5laurel");
        User user3 = new User(3, "Oliver", "oliver@tale.com", "k5oliver");
        User user4 = new User(4, "Asher", "asher@tale.com", "k5asher");
        User user5 = new User(5, "Michaela", "mickaela@tale.com", "k5michaela");
        User user6 = new User(6, "Wes", "wes@tale.com", "k5wes");
        
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        users.forEach (user -> database.users.put(user.getUserId(), user));
        
        User admin = new User(1, "Marina", "admin", "admin123");
        admin.promoteToAdmin();
        
        Tales kolobok = new Tales(1, "Народна казка", "Колобок", 
                "Пшеничний хліб кулястої форми з ознаками інтелекту випадково"
                        + " втік від своїх творців похилого віку в гонитві "
                        + "за ілюзією свободи, але в перипетіях харчового ланцюжка "
                        + "був поглинений представником фауни з родини собачих, "
                        + "роду лисиць, за допомогою нейролінгвістичного програмування", 
                "https://kazky.org.ua/zbirky/ukrajinsjki-narodni-kazky/kolobok");
        
        Tales hippo = new Tales (2, "Сутєєв В.Г.", "Бегемот, який боявся щеплень", 
                "Казка про боязливого бегемота, який втік з поліклініки, тому що боявся щеплень. "
                        + "І захворів на жовтуху. На щастя, його відвезли в лікарню і вилікували. "
                        + "А бегемоту стало дуже соромно за свою поведінку ...",
                "https://detskie-skazki.net/suteev/8-pro-begemota-kotoryj-boyalsya-privivok.html");
        
        Tales crokodile = new Tales(3, "Заходер Б.", "Ма-Тарі-Карі", 
                "Казка про справжнього крокодила, який жив в Африці. "
                        + "У нього все було страшне: голова, хвіст, паща і зуби. "
                        + "Всі звірі навколо його дуже боялися. "
                        + "Але одного разу у крокодила дуже розболілися зуби.",
                "https://detskie-skazki.net/zahoder/72-ma-tari-kari.html");
        
        Tales donkey = new Tales(4, "Енн Хогарт", "Мафін шукає клад", 
                "Історія про те, як ослик Мафин знайшов папірець з планом, "
                        + "де захований скарб. Він дуже зрадів і вирішив відразу"
                        + " піти на його пошуки. Але тут прийшли його друзі "
                        + "і теж вирішили знайти скарби.", 
                "https://www.litmir.me/br/?b=76685&p=1");
        
        List<Tales> tales = Arrays.asList(kolobok, hippo, crokodile, donkey);
        tales.forEach(tale -> database.tales.put(tale.getTaleId(), tale));    //?????? tale.getTaleId - not tales?
        
        kolobok.getLikers().addAll(Arrays.asList(user1, user3, user5, user6));
        hippo.getLikers().addAll(Arrays.asList(user2, user4, user5));
        crokodile.getLikers().addAll(Arrays.asList(user1, user2));
        donkey.getLikers().addAll(Arrays.asList(user4, user6, user3));
        
        user1.getLastWatched().addAll(Arrays.asList(hippo, crokodile));
        user2.getLastWatched().addAll(Arrays.asList(crokodile, donkey));
        user3.getLastWatched().addAll(Arrays.asList(hippo, donkey, kolobok));
        user4.getLastWatched().addAll(Arrays.asList(kolobok, crokodile));
        user5.getLastWatched().addAll(Arrays.asList(donkey, hippo));
        user6.getLastWatched().addAll(Arrays.asList(crokodile));
        
        user1.getLiked().addAll(Arrays.asList(kolobok, crokodile));
        user2.getLiked().addAll(Arrays.asList(hippo, crokodile));
        user3.getLiked().addAll(Arrays.asList(kolobok, donkey));
        user4.getLiked().addAll(Arrays.asList(hippo, donkey));
        user5.getLiked().addAll(Arrays.asList(kolobok, hippo));
        user6.getLiked().addAll(Arrays.asList(kolobok, donkey));
        
    }
}
