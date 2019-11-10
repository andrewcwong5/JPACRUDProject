package com.skilldistillery.buffets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.buffets.data.BuffetDAO;
import com.skilldistillery.buffets.entities.Buffets;

@Controller
public class BuffetController {

	@Autowired
	private BuffetDAO buffetDAO;
	
	Buffets buffet = buffetDAO.findById(fid);
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String index(Model model) {
		// TODO : Retrieve buffet list, add it to the model.
		model.addAttributes("buffet", buffet);
//		FilmDAOJpalmpl.List<Film> findAll();
	  return "WEB-INF/index.jsp";
	  // return "index"; // if using a ViewResolver.
	}  
	@RequestMapping(path="getFilm.do", method = RequestMethod.GET)
	public ModelAndView getFilm(@RequestParam("fid") int fid) {
	  ModelAndView mv = new ModelAndView();
	  
	  Buffets buffet = buffetDAO.findById(fid);
	  
	  mv.addObject("film", buffet);
	  mv.setViewName("WEB-INF/buffets/show.jsp");
  
	  return mv;
}
}
