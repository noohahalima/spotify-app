package com.code.spotify.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.code.spotify.service.UserService;
import com.code.spotify.entity.User;


@Controller
public class HomeController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/")
	public ModelAndView myHomePage()
	{
		
	Map<String, Object> model = new HashMap<String, Object>();

		return new ModelAndView("login", model);
	}
	
	@RequestMapping(value="/homee")
	public ModelAndView myHomeePage()
	{
		
	Map<String, Object> model = new HashMap<String, Object>();

		return new ModelAndView("homee", model);
	}
	
	@RequestMapping(value="/register")
	public String userRegister()
	{
		//return the name of the view i.e jsp file name
		return "registration";
	}
	
	@RequestMapping(value="/login")
	public String userlogin()
	{
		//return the name of the view i.e jsp file name
		return "login";
	}
	
	@RequestMapping(value="/processform",method=RequestMethod.POST)
	public String userRegisterProcess(HttpServletRequest request,Model model)
	{
		//get the getparameter(name of the control of each inside the form
		String name=request.getParameter("name");
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String message=" Please Confirm <br> Name :"+name+"<br> Email ID :"+emailid+"<br> Password:"+password;
		//add the the values into the Model object
		model.addAttribute("messages",message);
		
		//print the values 
		System.out.println("Name : "+name+" Email : "+emailid+" Password : "+password);
		//return the name of the view i.e jsp file name
		return "songslist";
	}
	
	@RequestMapping(value="/processlogin",method=RequestMethod.POST)
	public String userloginProcess(HttpServletRequest request,Model model,HttpSession session)
	{
		//get the getparameter(name of the control of each inside the form
		//getting the values on form submit
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String message="";
		String viewpagename="";
		//we have method to authenticate the user
		User user=	userservice.authenticateUser(emailid, password);
		//if user!=null valid user
		if(user!=null)
		{
			
			
			session.setAttribute("user", user);
	
			System.out.println("Expire Time in Min"+ session.getMaxInactiveInterval());
			//role of the user
		
		}
		else
		{
				message="Invalid loginId and Password" ;
				model.addAttribute("errormessages",message);
				viewpagename="login";
		}
		//add the the values into the Model object
		
	
		//print the values 
		//System.out.println("Name : "+name+" Email : "+emailid+" Password : "+password);
		//return the name of the view i.e jsp file name
		 return "redirect://songs/list";
	}
}
