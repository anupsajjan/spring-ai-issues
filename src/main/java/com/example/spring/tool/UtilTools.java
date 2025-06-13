package com.example.spring.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration(proxyBeanMethods = false)
public class UtilTools {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @io.swagger.v3.oas.annotations.media.Schema(description = "Request object for getting a lucky number for a given person name.")
    public record LuckyNumberRequest(String personName) {}

    @Bean("getLuckyNumberForGivenPersonName")
    @Description("Gets a lucky number for a given person name.")
    public Function< LuckyNumberRequest, Integer> getLuckyNumberForGivenPersonName() {
        return request -> {
            final Integer luckyNumber = request == null ? 7 : request.personName().length() + 100;
            return luckyNumber;
        };
    }

}
