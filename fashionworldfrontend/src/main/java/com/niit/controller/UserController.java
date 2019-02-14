package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

@Controller
public class UserController {
	@Autowired
    UserDetailDAO userDAO;
	
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public String addUser(Model m,@RequestParam("uName")String userName,@RequestParam("uPwd")String password,@RequestParam("uAddr")String customerAddr)
	{
		UserDetail user=new UserDetail();
		user.setUsername(userName);
		user.setPassword(password);
		user.setCustomerAddr(customerAddr);
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		
		userDAO.registerUser(user);
		
		m.addAttribute("pageinfo","Manage User");
		return "User";
	}

}
