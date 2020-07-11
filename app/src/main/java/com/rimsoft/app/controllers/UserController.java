package com.rimsoft.app.controllers;

import java.security.Principal;
import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rimsoft.app.entities.User;
import com.rimsoft.app.services.UserService;


import com.twilio.Twilio;

@Controller
public class UserController {
	
	private UserService userService;
    /**
    * @param userService the userService to set
    */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value="/users")
	public String list(Model model) {
		model.addAttribute("users", userService.getUsers());
		   return "users";
	}
	
	
	
	//temporary solution
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(User user, Principal principal) {
			return "login";
	}

	
	@RequestMapping(value="/login", method = RequestMethod.POST)	
	public String login(User user, Model model, HttpSession session) {
		
		//remove current session attritubes
		session.removeAttribute("code");
		session.removeAttribute("actualUser");
		String claimedName = user.getName();
		String name = null;
		if(userService.getUserByName(claimedName).size() > 0) {
			List users = userService.getUserByName(claimedName);
			
			User actualUser = (User) users.get(0);
//			name =actualUser.getName();
			model.addAttribute("actualUser", actualUser);
			
			//check if 2fa is set
			
			if(actualUser.isIs2fa()) {
				SmsSender smsS = new SmsSender();
				Twilio.init(smsS.ACCOUNT_SID, smsS.AUTH_TOKEN);
				
				String code = smsS.generateCode(7);
				session.setAttribute("code", code);
				session.setAttribute("actualUser", actualUser);
				smsS.sendSms(actualUser.getTel(), code);
				return "phone";
			}
			else {
				return "index";
			}
			
		}
		else {
			return "login";
		}
	}
	
	//temporary solution
	@RequestMapping(value = "/2fa", method = RequestMethod.GET)
	public String redirect() {
		return "login";
	}
	
	@RequestMapping(value = "/2fa", method = RequestMethod.POST)
	public String validateCode(String code,Model model ,HttpSession session) {
		String generatedCode = (String ) session.getAttribute("code");
		if(generatedCode.equals(code)) {
			model.addAttribute("actualUser",session.getAttribute("actualUser"));
			return "index";
//			return "true " + "code : " + code + "\n" + "generatedCode : " + generatedCode;
		}
		else {
			return "phone";
//			return "false " + "code : " + code + "\n" + "generatedCode : " + generatedCode;
		}
	}
}












