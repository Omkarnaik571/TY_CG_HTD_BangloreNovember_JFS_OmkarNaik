package springmvccom.capgemini.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import springmvccom.capgemini.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
    
	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Kya Yaroo..");
		return "index";
	}
  
//	@RequestMapping(path="/query",method = RequestMethod.GET)
	@GetMapping("/query")
	public String query(@RequestParam("name")String name,@RequestParam("age")int age,ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("age", age);
		return "query";
		
	}
	@GetMapping("/form")
	public String form() {
		
		return "form";
	}
	
	@PostMapping("/form")
//	public String form(String name,String email,String password,String gender,ModelMap map) {
	public String form(User user,ModelMap map) {
//		map.addAttribute("name", name);
//		map.addAttribute("gender", gender);
//		map.addAttribute("email", email);
//		map.addAttribute("password", password);
		map.addAttribute("name",user.getName());
		map.addAttribute("gender", user.getGender());
		map.addAttribute("email", user.getEmail());
		map.addAttribute("password", user.getPassword());
		return "form";
	}
	
	@GetMapping("/createcookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie=new Cookie("name", "Hash@432");
		response.addCookie(cookie);
		return "createcookie";
	}
	
	
	@GetMapping("/getcookie")
	public String getCookie(@CookieValue(name="name",required = false)String name, ModelMap map) {
		
		if(name != null) {
			map.addAttribute("name",name);	
		}
		else {
			map.addAttribute("name","Biswa");
		}
		
		
//		Cookie[] cookie=request.getCookies();
//		for (Cookie c1 : cookie) {
//			if(c1.getName().equals("name")) {
//				String value=c1.getValue();
//				
//			}
//		}   
		return "getcookie";
	}
	
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie")String movie,
			@PathVariable("hero")String hero,ModelMap map) {
		map.addAttribute("movie", movie);
		map.addAttribute("hero",hero);
		
		return "path";
	}
	@GetMapping("/forward")
	public String foroward() {
		return "forward:hello";
		
	}
	@GetMapping("redirect")
	public String reDirect() {
		return "redirect:https://www.google.com";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
//Creating a session
	@PostMapping("/login")
	public String login(String username,String password,HttpServletRequest request,ModelMap map) {
		if(username.equals("user")&&password.equals("qwerty")) {
			User user=new User();
			user.setName(username);
			user.setPassword(password);
			user.setEmail("user@gmail.com");
			user.setGender("M");
			HttpSession session =request.getSession(true);
		      session.setAttribute("user", user);
     		map.addAttribute("msg","User Login Successful");
			return "home";
		}else {
			map.addAttribute("msg", "Credentials Invalid..");
			return "login";
		}
	}
	
	//Validating a session
	@GetMapping("/home")
	public String home(@SessionAttribute(name= "user",required = false)User user) {
		if(user != null) {
			return "home";
		}    
		else {
			return "login";
		}
		
	}
	
	

	/*
	@PostMapping("/login")
	public String login(HttpSession session,String username,String password,ModelMap map) {
		if(username.equals("user")&&password.equals("qwerty")) {
		map.addAttribute("msg","User Login Successful");
			return "home";
		}else {
			session.invalidate();
			map.addAttribute("msg", "Credentials Invalid..");
			return "login";
		}

	}
	*/
	
	//Application level
	@GetMapping("/setappattribute")
	public String setAppAttribute() {
		context.setAttribute("msg",new Object());
		
		return "setcontext";
	}
	
	@GetMapping("getappattribute")
	public String getAppAttribute() {
		System.out.println(context.getAttribute("msg"));
		return "getcontext";
	}
	
	
	
	
}
