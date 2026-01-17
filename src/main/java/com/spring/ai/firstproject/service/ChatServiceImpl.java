package com.spring.ai.firstproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.spring.ai.firstproject.entitiy.Tut;


@Service
public class ChatServiceImpl implements ChatService{
	
	private ChatClient chatClient;
	
	@Value("classpath:/prompts/user-message.st")
	private Resource userMessage;
	
	@Value("classpath:prompts/system-message.st")
	private Resource systemMessage;
	
	public ChatServiceImpl(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@Override
	public Tut chat(String query) {
		
		//call the llm for response
//		String content = chatClient.prompt().user(prompt).system("As an cricket expert").call().content();
//		String prompt = "tell me about MS Dhoni?";
		Prompt prompt1 = new Prompt(query);
		
		var tutorials = chatClient.prompt(prompt1).call().entity(new ParameterizedTypeReference<Tut>() { 
			
		});
		
//		System.out.println(metaData);
		
		return tutorials;
		
	}
	
	public String chatTemplate() {
		
		//first step
//		PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName}? tell me example with {exampleName}").build();
//		
//		//render the template
//		String renderedMessage = strTemplate.render(Map.of("techName","Spring","exampleName","Spring Boot"));
//		
//		Prompt prompt = new Prompt(renderedMessage);
		
		
		
//		var systemPromptTemplate = SystemPromptTemplate.builder().template("You are a helpful coding assistant and expert in coding.").build();
//		var systemMessage = systemPromptTemplate.createMessage();
//		
//		var userPromptTemplate = PromptTemplate.builder().template("What is {techName}? tell me also about {techName2}").build();
//		var userMessage = userPromptTemplate.createMessage(Map.of("techName","Spring","techName2","Kafka"));
//		
//		Prompt prompt = new Prompt(systemMessage, userMessage);
//		
		
		return this.chatClient.prompt().system(system -> system.text(systemMessage)).user(user -> 	user.text(userMessage).param("TechName", "MongoDB")).call().content();
		
	}

}
