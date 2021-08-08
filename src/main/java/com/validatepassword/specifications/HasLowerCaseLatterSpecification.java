package com.validatepassword.specifications;

public class HasLowerCaseLatterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }
}