package net.schastny.contactmanager.dao;

import java.util.List;
import net.schastny.contactmanager.domain.Contact;

public interface ContractDAO {
    void add(Contact contact);
    List<Contact> getAll();
    void remove(Integer id);
}