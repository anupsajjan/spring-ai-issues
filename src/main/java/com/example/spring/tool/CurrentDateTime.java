package com.example.spring.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentDateTime {


    @Tool(description = "this method provides current date and time")
    public String getCurrentDateTime(){
        return LocalDateTime.now().toString();
    }
}
