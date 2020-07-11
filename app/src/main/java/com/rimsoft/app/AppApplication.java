package com.rimsoft.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rimsoft.app.controllers.UserController;
import com.rimsoft.app.services.UserService;

@SpringBootApplication
@Controller
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
}