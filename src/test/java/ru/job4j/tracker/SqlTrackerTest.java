package ru.job4j.tracker;

//import org.junit.Test;
//
//import java.util.List;
//
//import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlTrackerTest {
//
//    @Test
//    public void findAll() {
//        Store tracker = new SqlTracker();
//        tracker.init();
//        List<Item> rsl = tracker.findAll();
//        assertThat(rsl.get(0).getName(), is("Заполнить начальыне данные в таблице Items"));
//        assertThat(rsl.get(0).getId(), is("2"));
//        assertThat(rsl.get(1).getName(),
//                is("Реализовать механизм получения заявое из базы данных Tracker"));
//        assertThat(rsl.get(1).getId(), is("3"));
//    }
//
//    @Test
//    public void findByName() {
//        Store tracker = new SqlTracker();
//        tracker.init();
//        List<Item> rsl = tracker.findByName("Заполнить начальыне данные в таблице Items");
//        assertThat(rsl.get(0).getName(), is("Заполнить начальыне данные в таблице Items"));
//        assertThat(rsl.get(0).getId(), is("2"));
//    }
//
//    @Test
//    public void findById() {
//        Store tracker = new SqlTracker();
//        tracker.init();
//        Item rsl = tracker.findById("2");
//        assertThat(rsl.getName(), is("Заполнить начальыне данные в таблице Items"));
//        assertThat(rsl.getId(), is("2"));
//    }

    public Connection init() {
        try (InputStream in
                     = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}