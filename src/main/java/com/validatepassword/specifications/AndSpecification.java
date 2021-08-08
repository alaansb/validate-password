package com.validatepassword.specifications;

import java.util.List;

public class AndSpecification implements ValidatePasswordSpecification{

    List<ValidatePasswordSpecification> validatePasswordSpecifications;

    @Override
    public Boolean isSatisfiedBy(String password) {
        return validatePasswordSpecifications.stream()
                .noneMatch(validatePasswordSpecifications -> isSatisfiedBy(password).equals(Boolean.FALSE));
    }
}
