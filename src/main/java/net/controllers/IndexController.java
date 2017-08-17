package net.controllers;

import net.validators.RegistrationForm;
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
    public String index(Map<String, Object> map) {
        return "redirect:/news";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> map) {
        return "login";
    }

    @RequestMapping("/error403")
    public String error403(Map<String, Object> map) {
        return "error403";
    }

    @RequestMapping("/registration")
    public String registration(Map<String, Object> map) {
        map.put("registrationForm", new RegistrationForm());

        return "registration";
    }

}
