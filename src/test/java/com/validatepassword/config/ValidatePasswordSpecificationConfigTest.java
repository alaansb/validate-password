package com.validatepassword.config;

import com.validatepassword.specifications.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatePasswordSpecificationConfigTest {

    private final ValidatePasswordSpecificationConfig config = new ValidatePasswordSpecificationConfig();

    @Test
    void itShouldCreateSpecificationConfigWithValidationsOfPassword() {
        AndSpecification specification = config.validatePasswordSpecification();

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateNotEmptySpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateDuplicateCharacterSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateLowerCaseLatterSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateUpperCaseLatterSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateNineOrMoreCharactersSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateNumericSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateSpecialCharacterSpecification));

        assertTrue(specification.getSpecifications()
                .stream()
                .anyMatch(s -> s instanceof ValidateSpaceCharacterSpecification));
    }
}
