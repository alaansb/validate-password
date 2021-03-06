package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateUpperCaseLatterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateUpperCaseLatterSpecification specification =
            new ValidateUpperCaseLatterSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenPasswordHasUpperCaseLatter() {
        assertTrue(specification.isSatisfiedBy("A"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasUpperCaseLatter() {
        assertFalse(specification.isSatisfiedBy("a"));
    }

    @Test
    void itShouldReturnTrueWhenPasswordHasAnyUpperCaseLatter() {
        assertTrue(specification.isSatisfiedBy("teSt"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasAnyUpperCaseLatter() {
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
