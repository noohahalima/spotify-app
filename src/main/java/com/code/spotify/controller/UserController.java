package com.code.spotify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.code.spotify.entity.User;
import com.code.spotify.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;

	
	@RequestMapping("/list")
	public ModelAndView getAllUser()
	{
	 List<User> users=  userservice.getAll();
	 	return new ModelAndView("userlist","users",users);
	}
	@RequestMapping("/add")
	public ModelAndView createUser()
	{
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("user", new User());
		return new ModelAndView("user-form",model);
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView userSave(@Valid @ModelAttribute("user")User user,BindingResult result)
	{
		//System.out.println("Email:"+user.getEmail());
		//System.out.println("Role:"+user.getRole().getRoleid());
		//return new ModelAndView("user-form");
		if(result.hasErrors())
		{
			System.out.println("error");
			Map<String, Object> model = new HashMap<String, Object>();
			
			//model.put("user", new User());
			return new ModelAndView("login",model);
		}
		else
		{
		userservice.add(user);
		return new ModelAndView("login");
		}
	}
		@RequestMapping("/deleteuser")
		public ModelAndView deleteUser(@RequestParam("email") String email)
		{
		User user= userservice.getById(email);
		
			System.out.println(email);
			userservice.delete(email);
			return new ModelAndView("userlist");
		}
		
		@RequestMapping("/edituser")
		public ModelAndView editUser(@RequestParam("email") String email)
		{
		User user= userservice.getById(email);
		Map<String, Object> model = new HashMap<String, Object>();
	
		model.put("user", user);
		return new ModelAndView("user-form",model);
			
		}
	
}
