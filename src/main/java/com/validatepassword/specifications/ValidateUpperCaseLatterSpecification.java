package com.validatepassword.specifications;

public class ValidateUpperCaseLatterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}