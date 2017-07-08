package net.schastny.contactmanager.dao;

import java.util.List;

import net.schastny.contactmanager.domain.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact")
                .list();
    }

    public void remove(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }

    }
}