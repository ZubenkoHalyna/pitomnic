package net.schastny.contactmanager.web;

import java.util.Map;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/contact")
    public String listContacts(Map<String, Object> map) {

        map.put("contact", new Contact());
        map.put("contactList", contactService.getAll());

        return "contact";
    }

    @RequestMapping(value = "/add/contact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact,
                             BindingResult result) {

        contactService.add(contact);

        return "redirect:/index";
    }

    @RequestMapping("/delete/contact/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        contactService.remove(contactId);

        return "redirect:/index";
    }
}