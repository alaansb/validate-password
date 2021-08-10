package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateLowerCaseLatterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateLowerCaseLatterSpecification specification =
            new ValidateLowerCaseLatterSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenPasswordHasLowerCaseLatter() {
        assertTrue(specification.isSatisfiedBy("a"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasLowerCaseLatter() {
        assertFalse(specification.isSatisfiedBy("A"));
    }

    @Test
    void itShouldReturnTrueWhenPasswordHasAnyLowerCaseLatter() {
        assertTrue(specification.isSatisfiedBy("TEsT"));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasAnyLowerCaseLatter() {
        assertFalse(specification.isSatisfiedBy("TEST"));
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
