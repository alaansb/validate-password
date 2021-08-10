package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateNineOrMoreCharactersSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateNineOrMoreCharactersSpecification specification = new ValidateNineOrMoreCharactersSpecification(validateNotEmptySpecification);

    @Test
    void itShouldReturnTrueWhenLengthOfPasswordEqualsNine() {
        assertTrue(specification.isSatisfiedBy("123456789"));
    }

    @Test
    void itShouldReturnTrueWhenLengthOfPasswordIsMoreThanNine() {
        assertTrue(specification.isSatisfiedBy("1234567891"));
    }

    @Test
    void itShouldReturnFalseWhenLengthOfPasswordIsLessThanNine() {
        assertFalse(specification.isSatisfiedBy("12345678"));
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
