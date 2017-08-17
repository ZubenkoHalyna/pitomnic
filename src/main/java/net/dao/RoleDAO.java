package net.dao;

import net.model.Role;

import java.util.List;

public interface RoleDAO {
    void add(Role role);
    List<Role> getAll();
    void remove(Integer id);
    Role getById(Integer id);
}