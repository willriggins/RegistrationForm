package com.theironyard;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by will on 6/15/16.
 */
public class MainTest {

    public Connection startConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Main.createTables(conn);
        return conn;
    }

    @Test
    public void testUsers() throws SQLException {
        Connection conn = startConnection();
        User user = new User(1, "Alice", "17A Princess St", "Alice@gov.com");
        Main.insertUser(conn, user);
        ArrayList<User> users = Main.selectUsers(conn);
        conn.close();
        assertTrue(users.size() == 1);
    }

    @Test
    public void updateUsers() throws SQLException {
        Connection conn = startConnection();
        User user = new User(1, "Alice", "17A Princess St", "Alice@gov.com");
        Main.insertUser(conn, user);
        User updatedUser = new User(1, "Bob", "Other Street", "bob@gov.com");
        Main.updateUser(conn, updatedUser);
        ArrayList<User> users = Main.selectUsers(conn);

        assertTrue(users.get(0).username.equals("Bob"));
    }

    @Test
    public void deleteUsers() throws SQLException {
        Connection conn = startConnection();
        User user = new User(1, "Alice", "17A Princess St", "Alice@gov.com");
        Main.insertUser(conn, user);
        Main.deleteUser(conn, 1);

        ArrayList<User> users = Main.selectUsers(conn);
        conn.close();
        assertTrue(users.size() == 0);


    }


}