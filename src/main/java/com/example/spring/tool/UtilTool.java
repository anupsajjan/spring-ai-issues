package com.example.spring.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UtilTool {

    @Autowired
    CurrentDateTime currentDateTime;

    @Tool(description = "this method provide current date and time ")
    String getCurrentDateAndTime(){
        return currentDateTime.getCurrentDateTime();
    }
}
