package net.service;

import net.dao.UserDAO;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public List<User> getAll() {

        return userDAO.getAll();
    }

    @Transactional
    public void remove(Integer id) {
        userDAO.remove(id);
    }
}

