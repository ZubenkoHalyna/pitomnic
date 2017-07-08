package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.domain.User;

import java.util.List;

public interface UserService {

    public void add(User user);

    public List<User> getAll();

    public void remove(Integer id);
}
