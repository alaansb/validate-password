package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasLowerCaseLatterSpecificationTest {

    private HasLowerCaseLatterSpecification specification = new HasLowerCaseLatterSpecification();

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
}
