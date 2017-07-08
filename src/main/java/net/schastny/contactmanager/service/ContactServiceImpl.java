package net.schastny.contactmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.schastny.contactmanager.dao.ContractDAO;
import net.schastny.contactmanager.domain.Contact;

@org.springframework.stereotype.Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContractDAO contactDAO;

    @Transactional
    public void add(Contact contact) {
        contactDAO.add(contact);
    }

    @Transactional
    public List<Contact> getAll() {

        return contactDAO.getAll();
    }

    @Transactional
    public void remove(Integer id) {
        contactDAO.remove(id);
    }
}