package com.validatepassword.specifications;

public class ValidateLowerCaseLatterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }
}