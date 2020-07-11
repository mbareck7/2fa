package com.rimsoft.app.controllers;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
	
	public static final String ACCOUNT_SID = "Get this from twilio account";
	 public static final String AUTH_TOKEN = "Get this also from twilio account";
	 
	 
	    public void sendSms(String tel,String code) {
		    Message message = Message.creator(new PhoneNumber(tel),
			        new PhoneNumber("+1 256 563 5949"), 
			        "This si your code : " + code).create();
	    }
	    
	    
	    public String generateCode(int length) {
	    	String code = "";
	    	for(int i =0;i < length;i++) {
	    		code += ThreadLocalRandom.current().nextInt(0, 9 + 1);
	    	}
	    	return code;
	    }
}
