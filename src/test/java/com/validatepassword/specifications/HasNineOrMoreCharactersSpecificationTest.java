package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasNineOrMoreCharactersSpecificationTest {

    private HasNineOrMoreCharactersSpecification specification = new HasNineOrMoreCharactersSpecification();

    @Test
    public void itShouldReturnTrueWhenLengthOfPasswordEqualsNine() {
        assertTrue(specification.isSatisfiedBy("123456789"));
    }

    @Test
    public void itShouldReturnTrueWhenLengthOfPasswordIsMoreThanNine() {
        assertTrue(specification.isSatisfiedBy("1234567891"));
    }

    @Test
    public void itShouldReturnFalseWhenLengthOfPasswordIsLessThanNine() {
        assertFalse(specification.isSatisfiedBy("12345678"));
    }
}
