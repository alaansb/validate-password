package com.validatepassword.specifications;

import org.apache.logging.log4j.util.Strings;

public class IsNotEmptySpecification implements ValidatePasswordSpecification {
    @Override
    public Boolean isSatisfiedBy(String password) {
        return Strings.isNotBlank(password);
    }
}
