package com.rimsoft.app;
	import com.twilio.Twilio;
	import com.twilio.rest.api.v2010.account.Message;
	import com.twilio.type.PhoneNumber;
	
	
	//This is just a test class,
public class Sender {
	  // Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "Get this from twilio account";
	  public static final String AUTH_TOKEN = "Get this also from twilio account";

//	  public static void main(String[] args) {
//	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//	    
//	   
//
//	    Message message = Message.creator(new PhoneNumber("put your number here"),
//	        new PhoneNumber("+1 256 563 5949"), 
//	        "Test code : 1332").create();
//
//	    System.out.println(message.getSid());
//	  }
}
