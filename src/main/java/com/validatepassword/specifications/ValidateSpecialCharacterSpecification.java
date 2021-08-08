package com.validatepassword.specifications;

import java.util.function.IntPredicate;

public class ValidateSpecialCharacterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {

        IntPredicate predicate = value -> !Character.isLetterOrDigit(value);

        return password.chars()
                .anyMatch(predicate.and(value -> !Character.isWhitespace(value)));
    }
}
