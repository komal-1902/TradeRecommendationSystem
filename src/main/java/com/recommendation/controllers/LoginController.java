package com.recommendation.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.UserModel;
import com.recommendation.service.DatabaseService;

@RestController
@RequestMapping("/server")
public class LoginController {
	
	
	
	@RequestMapping("/login")
	public Boolean authenticate(@RequestBody UserModel user){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		DatabaseService db = new DatabaseService();
		String password = db.getPassword(user.getUsername());
		if(password.equals(user.getPassword())){
			System.out.println("Authenticate");
			return true;
		}
		else{
			System.out.println("No.");
			return false;
		}
	}

}
