package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasUpperCaseLatterSpecificationTest {

    private HasUpperCaseLatterSpecification specification = new HasUpperCaseLatterSpecification();

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
}
