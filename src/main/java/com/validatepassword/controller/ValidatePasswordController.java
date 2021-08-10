package com.validatepassword.controller;

import com.validatepassword.dto.PasswordRequest;
import com.validatepassword.service.ValidatePasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/validate-password")
@RestController
public class ValidatePasswordController {

    private final ValidatePasswordService validatePasswordService;

    public ValidatePasswordController(ValidatePasswordService validatePasswordService) {
        this.validatePasswordService = validatePasswordService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "")
    public Boolean isValidaPassword(@RequestBody PasswordRequest password) {
        return validatePasswordService.isValidPassword(password.getPassword());
    }
}
