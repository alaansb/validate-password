package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateNotEmptySpecificationTest {

    private final ValidateNotEmptySpecification specification = new ValidateNotEmptySpecification();

    @Test
    void itShouldReturnTrueWhenPasswordIsNotEmpty() {
        assertTrue(specification.isSatisfiedBy("test"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordIsEmpty() {
        assertFalse(specification.isSatisfiedBy(""));
    }

    @Test
    void itShouldReturnFalsePasswordIsNull() {
        assertFalse(specification.isSatisfiedBy(null));
    }
}
