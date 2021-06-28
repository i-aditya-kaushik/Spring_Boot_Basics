package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(@RequestParam("aid") int aid,@RequestParam("aname") String name,@RequestParam("tech") String tech) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		if(name!="")
		alien.setAname(name);
		if(tech!="")
		alien.setTech(tech);
		repo.save(alien);
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/delAlien")
	public ModelAndView delAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("delAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		repo.deleteById(aid);
		mv.addObject(alien);
		return mv;
	}
}
