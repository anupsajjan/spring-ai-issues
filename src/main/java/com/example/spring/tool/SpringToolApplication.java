package com.example.spring.tool;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.model.tool.ToolCallingChatOptions;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringToolApplication implements CommandLineRunner {

    @Autowired
    private ChatModel chatModel;
    private final ChatClient chatClient;

    SpringToolApplication(ChatClient.Builder chatClient) {

        this.chatClient = chatClient.build();
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringToolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Issue: unable to use tool using Dynamic Specification: @Bean
        // runtime error- java.lang.IllegalStateException: No @Tool annotated methods found in getLuckyNumberForGivenPersonName.Did you mean to pass a ToolCallback or ToolCallbackProvider? If so, you have to use .toolCallbacks() instead of .tool()

        //1st-Way
      String response1 = chatClient.prompt("can you give number for Ramesh")
                .tools("getLuckyNumberForGivenPersonName")
                .call()
                .content();

      System.out.println("Response -> "+response1);



      //2nd Way-Using Chat model

//        String response2= ChatClient.create(chatModel)
//                .prompt("can you give number for Ramesh")
//                .tools("getLuckyNumberForGivenPersonName")
//                .call()
//                .content();
//
//        System.out.println("Response -> "+response2);



      //3rd Way-Using Chat Options

//        ChatOptions chatOptions= ToolCallingChatOptions.builder()
//                .toolNames("getLuckyNumberForGivenPersonName")
//                .build();
//       String response3 = chatClient.prompt("can you give number for Ramesh")
//                .tools("getLuckyNumberForGivenPersonName")
//                .options(chatOptions)
//                .call()
//                .content();
//        System.out.println("Response -> "+response3);

    }
}


