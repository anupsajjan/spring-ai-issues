package com.example.spring.tool;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringToolApplication implements CommandLineRunner {

	private final ChatClient chatClient;

	@Autowired
	UtilTool currentDateTime;

	SpringToolApplication(ChatClient.Builder chatClient){

        this.chatClient = chatClient.build();
    }

	public static void main(String[] args) {


		SpringApplication.run(SpringToolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ChatClient.CallResponseSpec responseSpec= chatClient.prompt("What is the current date").toolNames("getCurrentDateTime").call();
		System.out.println("response "+responseSpec.content().toString());

	}
}


