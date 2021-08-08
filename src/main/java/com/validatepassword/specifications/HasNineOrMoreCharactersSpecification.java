package com.validatepassword.specifications;

public class HasNineOrMoreCharactersSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {
        password.length();
        return password.length() >= 9;
    }
}
