package com.validatepassword.specifications;

import java.util.Map;
import java.util.stream.Collectors;

public class ValidateDuplicateCharacterSpecification implements ValidatePasswordSpecification {

    private final ValidateNotEmptySpecification validateNotEmptySpecification;

    public ValidateDuplicateCharacterSpecification(ValidateNotEmptySpecification validateNotEmptySpecification) {
        this.validateNotEmptySpecification = validateNotEmptySpecification;
    }

    @Override
    public Boolean isSatisfiedBy(String password) {

        if(Boolean.FALSE.equals(validateNotEmptySpecification.isSatisfiedBy(password))) {
            return false;
        }

        Map<Character, Long> duplicateCharacter = password.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        return duplicateCharacter.values().stream().noneMatch(value -> value > 1);
    }
}