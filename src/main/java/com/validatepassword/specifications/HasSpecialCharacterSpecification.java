package com.validatepassword.specifications;

import java.util.function.IntPredicate;

public class HasSpecialCharacterSpecification implements ValidatePasswordSpecification {

    @Override
    public Boolean isSatisfiedBy(String password) {

        IntPredicate predicate = Character::isLetterOrDigit;

        return password.chars().anyMatch(predicate.and(Character::isWhitespace));
    }
}
