package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateNumericSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateNumericSpecification specification = new ValidateNumericSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenPasswordHasDigit() {
        assertTrue(specification.isSatisfiedBy("1"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasDigit() {
        assertFalse(specification.isSatisfiedBy("a"));
    }

    @Test
    void itShouldReturnTrueWhenPasswordHasAnyDigit() {
        assertTrue(specification.isSatisfiedBy("tes1t"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasAnyDigit() {
        assertFalse(specification.isSatisfiedBy("test"));
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
