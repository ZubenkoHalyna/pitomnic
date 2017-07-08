package net.schastny.contactmanager.service;

import net.schastny.contactmanager.dao.RoleDAO;
import net.schastny.contactmanager.dao.UserDAO;
import net.schastny.contactmanager.domain.Role;
import net.schastny.contactmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Transactional
    public List<Role> getAll() {

        return roleDAO.getAll();
    }

    @Transactional
    public void remove(Integer id) {
        roleDAO.remove(id);
    }

    @Transactional
    public Role getById(int id) {
        return roleDAO.getById(id);
    }
}
