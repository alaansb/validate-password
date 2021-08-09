package com.validatepassword.specifications;

public class ValidateUpperCaseLatterSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateUpperCaseLatterSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(validateNotEmptySpecification.isSatisfiedBy(password)) {
            return password.chars().anyMatch(Character::isUpperCase);
        }

        return false;
    }
}