package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Alien a) {
//		System.out.println("Request is accepted successfully");
		ModelAndView mv = new ModelAndView();
//		System.out.println("Hi "+ myName);
		mv.addObject("object",a);
		mv.setViewName("home");
		return mv;
	}
}
