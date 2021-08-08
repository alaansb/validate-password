package com.validatepassword.specifications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AndSpecificationTest {

    private static final String PASSWORD = "test";
    private AndSpecification specification;

    @Mock
    private ValidateNotEmptySpecification validateNotEmptySpecification;
    @Mock
    private ValidateSpecialCharacterSpecification validateSpecialCharacterSpecification;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        List<ValidatePasswordSpecification> specifications = Arrays.asList(validateNotEmptySpecification,
                validateSpecialCharacterSpecification);

        specification = new AndSpecification(specifications);
    }

    @Test
    public void itShouldReturnTrueWhenAllSpecificationsReturnedTrue() {
        when(validateNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);
        when(validateSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);

        assertTrue(specification.isSatisfiedBy(PASSWORD));
    }

    @Test
    public void itShouldReturnFalseWhenAnySpecificationsReturnedFalse() {
        when(validateNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);
        when(validateSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);

        assertFalse(specification.isSatisfiedBy(PASSWORD));
    }

    @Test
    public void itShouldReturnFalseWhenAllSpecificationsReturnedFalse() {
        when(validateNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);
        when(validateSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);

        assertFalse(specification.isSatisfiedBy(PASSWORD));
    }
}
