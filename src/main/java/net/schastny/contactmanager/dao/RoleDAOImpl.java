package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getAll() {

        return sessionFactory.getCurrentSession().createQuery("from Role")
                .list();
    }

    public void remove(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(
                Role.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    public Role getById(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(
                Role.class, id);
        return role;
    }
}

