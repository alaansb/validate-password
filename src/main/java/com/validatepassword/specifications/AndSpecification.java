package com.validatepassword.specifications;

import java.util.List;

public class AndSpecification implements ValidatePasswordSpecification{

    private List<ValidatePasswordSpecification> specifications;

    public AndSpecification(List<ValidatePasswordSpecification> specifications) {
        this.specifications = specifications;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {
        return specifications.stream()
                .noneMatch(specification -> specification.isSatisfiedBy(password).equals(Boolean.FALSE));
    }
}
