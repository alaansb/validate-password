package com.validatepassword.specifications;

public class ValidateNumericSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateNumericSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(validateNotEmptySpecification.isSatisfiedBy(password)) {
            return password.chars().anyMatch(Character::isDigit);
        }

        return false;
    }
}