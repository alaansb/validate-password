package com.validatepassword.specifications;

public class ValidateSpaceCharacterSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateSpaceCharacterSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(Boolean.TRUE.equals(validateNotEmptySpecification.isSatisfiedBy(password))) {
            return password.chars().noneMatch(Character::isWhitespace);
        }

        return false;
    }
}