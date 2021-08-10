package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateDuplicateCharacterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateDuplicateCharacterSpecification specification =
            new ValidateDuplicateCharacterSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenPasswordNotHasDuplicateCharacter() {
        assertTrue(specification.isSatisfiedBy("ab"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordHasDuplicateCharacter() {
        assertFalse(specification.isSatisfiedBy("aa"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordHasAnyDuplicateCharacter() {
        assertFalse(specification.isSatisfiedBy("test-test"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordIsEmpty() {
        assertFalse(specification.isSatisfiedBy(""));
    }

    @Test
    void itShouldReturnFalseWhenPasswordIsNull() {
        assertFalse(specification.isSatisfiedBy(null));
    }
}
