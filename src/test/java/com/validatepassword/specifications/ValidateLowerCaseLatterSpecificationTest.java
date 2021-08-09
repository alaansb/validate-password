package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateLowerCaseLatterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateLowerCaseLatterSpecification specification =
            new ValidateLowerCaseLatterSpecification(validateNotEmptySpecification);

    @Test
    public void itShouldReturnTrueWhenPasswordHasLowerCaseLatter() {
        assertTrue(specification.isSatisfiedBy("a"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasLowerCaseLatter() {
        assertFalse(specification.isSatisfiedBy("A"));
    }

    @Test
    public void itShouldReturnTrueWhenPasswordHasAnyLowerCaseLatter() {
        assertTrue(specification.isSatisfiedBy("TEsT"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasAnyLowerCaseLatter() {
        assertFalse(specification.isSatisfiedBy("TEST"));
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
