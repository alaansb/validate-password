package com.validatepassword.specifications;

public class ValidateNumericSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }
}