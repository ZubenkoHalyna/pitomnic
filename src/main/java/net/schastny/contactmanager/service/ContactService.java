package net.schastny.contactmanager.service;

import java.util.List;
import net.schastny.contactmanager.domain.Contact;

public interface ContactService {

    public void add(Contact contact);

    public List<Contact> getAll();

    public void remove(Integer id);
}