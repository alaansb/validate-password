package com.validatepassword.service;

import com.validatepassword.specifications.ValidatePasswordSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ValidatePasswordServiceTest {

    private static final String PASSWORD = "test";

    @Mock
    private ValidatePasswordSpecification validatePasswordSpecification;
    @InjectMocks
    private ValidatePasswordService validatePasswordService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldReturnTrueWhenPasswordIsValid() {
        when(validatePasswordSpecification.isSatisfiedBy(any())).thenReturn(Boolean.TRUE);

        assertTrue(validatePasswordService.isValidPassword(PASSWORD));
    }

    @Test
    public void itShouldReturnFalseWhenPasswordIsNotValid() {
        when(validatePasswordSpecification.isSatisfiedBy(any())).thenReturn(Boolean.FALSE);

        assertFalse(validatePasswordService.isValidPassword(PASSWORD));
    }

}
