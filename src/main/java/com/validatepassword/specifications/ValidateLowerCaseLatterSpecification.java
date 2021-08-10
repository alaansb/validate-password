package com.validatepassword.specifications;

public class ValidateLowerCaseLatterSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateLowerCaseLatterSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(Boolean.TRUE.equals(validateNotEmptySpecification.isSatisfiedBy(password))) {
            return password.chars().anyMatch(Character::isLowerCase);
        }

        return false;
    }
}