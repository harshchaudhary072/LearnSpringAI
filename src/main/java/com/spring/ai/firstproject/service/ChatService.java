package com.spring.ai.firstproject.service;

import java.util.List;

import com.spring.ai.firstproject.entitiy.Tut;

public interface ChatService {
	
	Tut chat(String query);
	
	public String chatTemplate();

}
