package com.techelevator.model;

public interface UserDAO {

    User getUser(String email);
    void saveUser(User user);

}
