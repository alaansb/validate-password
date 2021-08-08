package com.validatepassword.specifications;

public class HasUpperCaseLatterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}