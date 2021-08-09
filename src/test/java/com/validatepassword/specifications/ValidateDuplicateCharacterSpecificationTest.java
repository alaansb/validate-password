package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateDuplicateCharacterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateDuplicateCharacterSpecification specification =
            new ValidateDuplicateCharacterSpecification(validateNotEmptySpecification);

    @Test
    public void itShouldReturnTrueWhenPasswordNotHasDuplicateCharacter() {
        assertTrue(specification.isSatisfiedBy("ab"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordHasDuplicateCharacter() {
        assertFalse(specification.isSatisfiedBy("aa"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordHasAnyDuplicateCharacter() {
        assertFalse(specification.isSatisfiedBy("test-test"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordIsEmpty() {
        assertFalse(specification.isSatisfiedBy(""));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordIsNull() {
        assertFalse(specification.isSatisfiedBy(null));
    }
}
