package com.example.SQL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SQL.UserDao.userdao;
import com.example.SQL.model.User;


@RestController
@RequestMapping(path="/demo")
public class Controller {
	@Autowired
	private userdao dao;
	
	 @PostMapping(path="/add") 
	 public @ResponseBody String addNewUser (@RequestParam String name)
	 {
		 User n = new User();
		    n.setName(name);
		    dao.save(n);
		    return "Saved";
	 }
	

}
