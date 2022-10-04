package com.example.demo.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {

    
    private final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,20}$";
    private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isValid(String password, ConstraintValidatorContext cvc) {

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
