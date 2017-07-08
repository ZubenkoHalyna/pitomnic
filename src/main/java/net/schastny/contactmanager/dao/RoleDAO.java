package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Role;
import net.schastny.contactmanager.domain.User;

import java.util.List;

public interface RoleDAO {
    void add(Role role);
    List<Role> getAll();
    void remove(Integer id);
    Role getById(Integer id);
}