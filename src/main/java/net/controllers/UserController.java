package net.controllers;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import net.model.User;
import net.service.UserService;
import net.validators.RegistrationValidator;
import net.model.Role;
import net.service.RoleService;
import net.validators.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RegistrationValidator registrationValidator;

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String registration(Map<String, Object> map) {
        map.put("registrationForm", new RegistrationForm());

        return "redirect:../registration";
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public String addUser(Locale locale, @ModelAttribute("registrationForm") RegistrationForm registrationForm,
                          BindingResult result) {
        registrationForm.setLocale(locale);
        registrationValidator.validate(registrationForm, result);
        if (result.hasErrors()) {
            return "registration";
        }

        User user = new User();
        user.setLogin(registrationForm.getLogin());
        user.setPassword(
                Hashing.sha1().hashString(registrationForm.getPassword(), Charsets.UTF_8 ).toString());
        user.setEnabled(true);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(2));
        user.setRoles(roles);
        userService.add(user);

        return "redirect:/login";
    }
}
