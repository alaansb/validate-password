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
    private IsNotEmptySpecification isNotEmptySpecification;
    @Mock
    private HasSpecialCharacterSpecification hasSpecialCharacterSpecification;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        List<ValidatePasswordSpecification> specifications = Arrays.asList(isNotEmptySpecification,
                hasSpecialCharacterSpecification);

        specification = new AndSpecification(specifications);
    }

    @Test
    public void itShouldReturnTrueWhenAllSpecificationsReturnedTrue() {
        when(isNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);
        when(hasSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);

        assertTrue(specification.isSatisfiedBy(PASSWORD));
    }

    @Test
    public void itShouldReturnFalseWhenAnySpecificationsReturnedFalse() {
        when(isNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);
        when(hasSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);

        assertFalse(specification.isSatisfiedBy(PASSWORD));
    }

    @Test
    public void itShouldReturnFalseWhenAllSpecificationsReturnedFalse() {
        when(isNotEmptySpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);
        when(hasSpecialCharacterSpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);

        assertFalse(specification.isSatisfiedBy(PASSWORD));
    }
}
