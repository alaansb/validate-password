package com.validatepassword.controller;

import com.validatepassword.service.ValidatePasswordService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ValidatePasswordController.class)
class ValidatePasswordControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ValidatePasswordService validatePasswordService;

    @Test
    void itShouldReturnOkStatusCodeAndTrueInResponseBodyWhenPasswordIsValid() throws Exception {

        doReturn(Boolean.TRUE)
                .when(validatePasswordService).isValidPassword("test");

        mvc.perform(post("/validate-password")
                .content("{\"password\":\"test\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void itShouldReturnOkStatusCodeAndFalseInResponseBodyWhenPasswordIsInvalid() throws Exception {

        doReturn(Boolean.FALSE)
                .when(validatePasswordService).isValidPassword("test");

        mvc.perform(post("/validate-password")
                .content("{\"password\":\"test\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}
