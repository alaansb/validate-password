package com.validatepassword.specifications;

public class ValidateNineOrMoreCharactersSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateNineOrMoreCharactersSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(validateNotEmptySpecification.isSatisfiedBy(password)) {
            return password.length() >= 9;
        }

        return false;
    }
}
