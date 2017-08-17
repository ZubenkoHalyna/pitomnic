package net.service;

import net.model.User;

import java.util.List;

public interface UserService {

    public void add(User user);

    public List<User> getAll();

    public void remove(Integer id);
}
