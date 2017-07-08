package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.domain.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    List<User> getAll();
    void remove(Integer id);
}