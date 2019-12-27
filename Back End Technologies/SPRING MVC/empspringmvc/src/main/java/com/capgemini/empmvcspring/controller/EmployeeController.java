package com.capgemini.empmvcspring.controller;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.empmvcspring.bean.EmployeeBean;
import com.capgemini.empmvcspring.service.EmployeeService;

@Controller
public class EmployeeController {
   
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email,String password,ModelMap map,HttpServletRequest request) {
		EmployeeBean bean=service.authenticate(email, password);
		if(bean ==null) {
			map.addAttribute("msg", "Invalid Credentials");
			return "login";
		}
			HttpSession session=request.getSession();
			session.setAttribute("bean", bean);
			
			return "home";
	
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(EmployeeBean bean,ModelMap map) {
	  boolean check=service.register(bean);
	   if(check) {
		   map.addAttribute("msg", "You have registered to employee portal successfully !! ");
	   }
	   else {
		   map.addAttribute("msg", "This email already exists !! ");
	   }
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		         if(session != null) {
		        	 session.invalidate();
		        	 map.addAttribute("msg", "You have been logged out successfully !!");
		        	 return "login";
		         }
		         else {
		        	 map.addAttribute("msg", "You have already logged out !!");
		        	 return "login";	 
		         }		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("key")String key,ModelMap map
			,@SessionAttribute(name="bean",required = false)EmployeeBean bean) {
		if(bean != null) {
			List<EmployeeBean> result=service.getAllEmployees(key);
			   map.addAttribute("list",result);
			   map.addAttribute("msg", "The Employee Details Found !!");
			   return "home";
		}
		else {
			return "login";
		}
		
	}

	
	@GetMapping("/changepassword")
	public String changePassword() {
		return "change";
	}
	
	@PostMapping("/changepassword")
	public String changePassword(ModelMap map,String password,@SessionAttribute(name="bean",required = false)EmployeeBean bean2) {
		   if(bean2 != null) {
			   boolean isModified=service.changePassword(bean2.getId(), password);
				map.addAttribute("msg", "Password modified Successfully !!");
				return "home";
		   }
		   else {
			   map.addAttribute("msg", "Password modification unsuccessful !!");
			   return "login";
		   }
	}
	
	
	
}
