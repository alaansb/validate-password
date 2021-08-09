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

        ValidateNotEmptySpecification validateNotEmptySpecification = new ValidateNotEmptySpecification();

        List<ValidatePasswordSpecification> specifications = Arrays.asList(new ValidateNotEmptySpecification(),
                new ValidateNineOrMoreCharactersSpecification(validateNotEmptySpecification),
                new ValidateNumericSpecification(validateNotEmptySpecification),
                new ValidateLowerCaseLatterSpecification(validateNotEmptySpecification),
                new ValidateUpperCaseLatterSpecification(validateNotEmptySpecification),
                new ValidateSpecialCharacterSpecification(validateNotEmptySpecification),
                new ValidateDuplicateCharacterSpecification(validateNotEmptySpecification));

        return new AndSpecification(specifications);
    }
}
