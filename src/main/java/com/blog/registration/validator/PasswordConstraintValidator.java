package com.blog.registration.validator;

import com.blog.registration.annotation.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

import static org.apache.tomcat.util.buf.StringUtils.join;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        List<Rule> rules = new ArrayList<>();
        //Rule 1: Password length should be in between 8 and 16 characters
        rules.add(new LengthRule(8, 16));
        //Rule 2: No whitespace allowed
        rules.add(new WhitespaceRule());
        //Rule 3.a: At least one Upper-case character
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        //Rule 3.b: At least one Lower-case character
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        //Rule 3.c: At least one digit
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        //Rule 3.d: At least one special character
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));
        //Rule: 1 to 5 numbers are not allowed
        rules.add(new NumberRangeRule(1, 5));
        final PasswordValidator validator = new PasswordValidator(rules);
        final RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(join(validator.getMessages(result))).addConstraintViolation();
        return false;
    }

}