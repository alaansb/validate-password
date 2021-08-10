package com.validatepassword.specifications;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class ValidateSpecialCharacterSpecificationTest {

    private final ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();
    private final ValidateSpecialCharacterSpecification specification =
            new ValidateSpecialCharacterSpecification(validateNotEmptySpecification);

    @ParameterizedTest
    @ValueSource( strings= {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+"})
    void itShouldReturnTrueWhenPasswordHasSpecialCharacter(String input) {
        assertTrue(specification.isSatisfiedBy(input));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasSpecialCharacter() {
        assertFalse(specification.isSatisfiedBy("a"));
    }

    @ParameterizedTest
    @ValueSource( strings= {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+"})
    void itShouldReturnTrueWhenPasswordHasAnySpecialCharacter(String input) {
        assertTrue(specification.isSatisfiedBy("tes".concat(input).concat("t")));
    }

    @Test
    void itShouldReturnFalseWhenPasswordNotHasAnySpecialCharacter() {
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
