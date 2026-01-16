package com.spring.ai.firstproject.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
	
	private ChatClient chatClient;
	
	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@Override
	public String chat(String query) {
		
		//call the llm for response
//		String content = chatClient.prompt().user(prompt).system("As an cricket expert").call().content();
//		String prompt = "tell me about MS Dhoni?";
		Prompt prompt1 = new Prompt(query);
		
		var content = chatClient.prompt(prompt1).call().chatResponse().getResult().getOutput().getText();
		
//		System.out.println(metaData);
		
		return content;
	}

}
