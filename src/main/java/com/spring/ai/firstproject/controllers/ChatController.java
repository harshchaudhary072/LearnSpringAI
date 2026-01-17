package com.spring.ai.firstproject.controllers;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.firstproject.entitiy.Tut;
import com.spring.ai.firstproject.service.ChatService;

@RestController
@RequestMapping
public class ChatController {
	
//	private ChatClient chatClient;
	
	private ChatService chatService;
	
//	private ChatClient openAiChatClient;
//	
//	private ChatClient ollamaChatClient;
	
//	public ChatController(@Qualifier("ollamaChatClient") ChatClient ollamaChatClient, @Qualifier("openAiChatClient") ChatClient openAiChatClient) {
//		this.ollamaChatClient = ollamaChatClient;
//		this.openAiChatClient = openAiChatClient;
//	}
	
//	public ChatController(ChatClient.Builder chatClientBuilder) {
//		this.chatClient = chatClientBuilder.build();
//	}
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	
//	public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
//		//this.chatClient = builder.build();
//		
//		this.openAiChatClient = ChatClient.builder(openAiChatModel).build();
//		this.ollamaChatClient = ChatClient.builder(ollamaChatModel).build(); 
//	}
	
	@GetMapping("/chat")
	public ResponseEntity<Tut> chat(@RequestParam(value ="q", required = true) String q){
		
		
		return ResponseEntity.ok(chatService.chat(q));
	}
}
