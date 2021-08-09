package com.validatepassword.specifications;

import java.util.function.IntPredicate;

public class ValidateSpecialCharacterSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateSpecialCharacterSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(!validateNotEmptySpecification.isSatisfiedBy(password)) {
            return false;
        }

        IntPredicate predicate = value -> !Character.isLetterOrDigit(value);

        return password.chars()
                .anyMatch(predicate.and(value -> !Character.isWhitespace(value)));
    }
}
