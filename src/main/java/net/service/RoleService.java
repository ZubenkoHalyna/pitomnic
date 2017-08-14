package net.service;

import net.domain.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);
    List<Role> getAll();
    void remove(Integer id);
    Role getById(int id);
}
