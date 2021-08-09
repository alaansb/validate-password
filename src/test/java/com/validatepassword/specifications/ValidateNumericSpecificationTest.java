package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateNumericSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateNumericSpecification specification = new ValidateNumericSpecification(validateNotEmptySpecification);

    @Test
    public void itShouldReturnTrueWhenPasswordHasDigit() {
        assertTrue(specification.isSatisfiedBy("1"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasDigit() {
        assertFalse(specification.isSatisfiedBy("a"));
    }

    @Test
    public void itShouldReturnTrueWhenPasswordHasAnyDigit() {
        assertTrue(specification.isSatisfiedBy("tes1t"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasAnyDigit() {
        assertFalse(specification.isSatisfiedBy("test"));
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
