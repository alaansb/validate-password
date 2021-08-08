package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsNotEmptySpecificationTest {

    private IsNotEmptySpecification specification = new IsNotEmptySpecification();

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
