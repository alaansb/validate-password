package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateUpperCaseLatterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateUpperCaseLatterSpecification specification =
            new ValidateUpperCaseLatterSpecification(validateNotEmptySpecification);

    @Test
    public void itShouldReturnTrueWhenPasswordHasUpperCaseLatter() {
        assertTrue(specification.isSatisfiedBy("A"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasUpperCaseLatter() {
        assertFalse(specification.isSatisfiedBy("a"));
    }

    @Test
    public void itShouldReturnTrueWhenPasswordHasAnyUpperCaseLatter() {
        assertTrue(specification.isSatisfiedBy("teSt"));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordNotHasAnyUpperCaseLatter() {
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
