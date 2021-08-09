package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateNotEmptySpecificationTest {

    private final ValidateNotEmptySpecification specification = new ValidateNotEmptySpecification();

    @Test
    public void itShouldReturnTrueWhenPasswordIsNotEmpty() {
        assertTrue(specification.isSatisfiedBy("test"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordIsEmpty() {
        assertFalse(specification.isSatisfiedBy(""));
    }

    @Test
    public void itShouldReturnFalsePasswordIsNull() {
        assertFalse(specification.isSatisfiedBy(null));
    }
}
