package com.validatepassword.config;

import com.validatepassword.specifications.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ValidatePasswordSpecificationConfig {

    @Bean
    public AndSpecification validatePasswordSpecification() {
        List<ValidatePasswordSpecification> specifications = Arrays.asList(new ValidateNotEmptySpecification(),
                new ValidateNineOrMoreCharactersSpecification(),
                new ValidateNumericSpecification(),
                new ValidateLowerCaseLatterSpecification(),
                new ValidateUpperCaseLatterSpecification(),
                new ValidateSpecialCharacterSpecification());

        return new AndSpecification(specifications);
    }
}
