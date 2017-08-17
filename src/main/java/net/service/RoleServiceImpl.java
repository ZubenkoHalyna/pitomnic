package net.service;

import net.dao.RoleDAO;
import net.model.Role;
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
