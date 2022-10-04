/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author hVeraros
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private final String phoneNumberPatter = "^\\d{10}$";
    private final Pattern pattern = Pattern.compile(phoneNumberPatter);

    @Override
    public boolean isValid(String PhoneNumber, ConstraintValidatorContext cvc) {
        Matcher matcher = pattern.matcher(PhoneNumber);
        if (PhoneNumber.length() == 10) {
            return true;
        } else if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
