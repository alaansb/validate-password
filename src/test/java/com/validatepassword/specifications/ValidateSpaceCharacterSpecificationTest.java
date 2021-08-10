package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateSpaceCharacterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateSpaceCharacterSpecification specification =
            new ValidateSpaceCharacterSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenPasswordNotHasSpaceCharacter() {
        assertTrue(specification.isSatisfiedBy("A"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotSpaceCharacter() {
        assertFalse(specification.isSatisfiedBy(" "));
    }

    @Test
    void itShouldReturnTrueWhenPasswordNotHasAnySpaceCharacter() {
        assertTrue(specification.isSatisfiedBy("test"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordHasAnySpaceCharacter() {
        assertFalse(specification.isSatisfiedBy("te st"));
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
