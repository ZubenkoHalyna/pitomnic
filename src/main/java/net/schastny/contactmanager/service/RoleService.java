package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);
    List<Role> getAll();
    void remove(Integer id);
    Role getById(int id);
}
