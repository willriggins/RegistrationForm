package com.theironyard;

/**
 * Created by will on 6/15/16.
 */
public class User {
    Integer id;
    String username;
    String address;
    String email;

    public User(Integer id, String username, String address, String email) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
