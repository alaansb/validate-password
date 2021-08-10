package com.validatepassword.service;

import com.validatepassword.specifications.ValidatePasswordSpecification;
import org.springframework.stereotype.Service;

@Service
public class ValidatePasswordService {

    private final ValidatePasswordSpecification validatePasswordSpecification;

    public ValidatePasswordService(ValidatePasswordSpecification validatePasswordSpecification) {
        this.validatePasswordSpecification = validatePasswordSpecification;
    }

    public Boolean isValidPassword(String password) {
        return validatePasswordSpecification.isSatisfiedBy(password);
    }
}
