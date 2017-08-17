package net.dao;

import net.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> getAll();
    void remove(Integer id);
}