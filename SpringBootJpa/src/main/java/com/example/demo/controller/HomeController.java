package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/getAlienbyTech")
	public ModelAndView getAlienbyTech(@RequestParam("tech") String tech) {
		ModelAndView mv = new ModelAndView("showByTech.jsp");
		List<Alien> outlist = repo.findByTech(tech);
		System.out.println(outlist);
		Alien alien = outlist.get(0); 
		mv.addObject(alien);
		return mv;
	}
	
	// ---------------------------- REST --------------------------- 
	// @RequestMapping(path = "/aliens", produces = {"application/xml"})
	// To restrict return type in the format of xml ^
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien_rest(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
//	@PostMapping(path="/alien",consumes= {"application/json"})
	@PostMapping("/alien")
	@ResponseBody
	public Alien postAlien_rest(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/alien/tech/{tech}")
	@ResponseBody
	public List<Alien> getAlien_tech(@PathVariable("tech") String tech) {
		return repo.findByTech(tech);
	}
}
