package net.schastny.contactmanager.validators;

import net.schastny.contactmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.Locale;

@Component
public class RegistrationValidator implements Validator{
    @Autowired
    private MessageSource messageSource;

    public boolean supports(Class<?> c) {
        return RegistrationForm.class.isAssignableFrom(c);
    }

    private String getMsg(String msg, Locale locale){
        return messageSource.getMessage(msg, new String[]{locale.getDisplayName(locale)}, locale);
    }

    public void validate(Object target, Errors errors) {
        RegistrationForm registrationForm = (RegistrationForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty", getMsg("label.loginempty", registrationForm.getLocale()));

        String username = registrationForm.getLogin();
        if ((username.length()) > 20) {
            errors.rejectValue("login", "login.tooLong", getMsg("label.logintooLong", registrationForm.getLocale()));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", getMsg("label.passwordempty", registrationForm.getLocale()));
        if (!(registrationForm.getPassword()).equals(registrationForm
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", getMsg("label.passwordDontMatch", registrationForm.getLocale()));
        }

        //if( !EmailValidator.getInstance().isValid( signupForm.getEmail() ) ){
        //    errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        //}
    }
}
