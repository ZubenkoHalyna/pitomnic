package net.schastny.contactmanager.web;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.domain.User;
import net.schastny.contactmanager.service.ContactService;
import net.schastny.contactmanager.validators.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
        return "redirect:/contact";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> map) {
        return "login";
    }

    @Autowired
    private ContactService contactService;

    @RequestMapping("/registration")
    public String registration(Map<String, Object> map) {
        map.put("registrationForm", new RegistrationForm());

        return "registration";
    }

}
