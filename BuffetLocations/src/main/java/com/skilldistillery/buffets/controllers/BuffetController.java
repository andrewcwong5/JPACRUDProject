package com.skilldistillery.buffets.controllers;

import java.util.List;

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
	
	int id;
	Buffets buffet = buffetDAO.findById(id);
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String index(Model model) {
		// Retrieves buffet list, add it to the model.
		model.addAttribute("buffet", buffet);
//		FilmDAOJpalmpl.List<Film> findAll();
	  return "WEB-INF/index.jsp";
	  // return "index"; // if using a ViewResolver.
	}  
	@RequestMapping(path="getBuffet.do", method = RequestMethod.GET)
	public ModelAndView getBuffet(@RequestParam("id") int id) {
	  ModelAndView mv = new ModelAndView();
	  
	  Buffets buffet = buffetDAO.findById(id);
	  
	  mv.addObject("buffet", buffet);
	  mv.setViewName("WEB-INF/buffets/show.jsp");
  
	  return mv;
	}
	
		
		// WHEN A Buffet IS ADDED THIS WILL ROUTE THE USER TO THE SEARCH PAGE WITH THE INPUT THEY PUT IN.
		@RequestMapping(path = "add.do", method = RequestMethod.POST)
		public ModelAndView addBuffet(Buffets buffet) {
			boolean buffetAdd = buffetDAO.createBuffet(buffet);
			ModelAndView mv = new ModelAndView();
			if (buffetAdd) {
				mv.addObject("result", buffet);
				mv.setViewName("WEB-INF/updateSuccessful.jsp");
			} else {
				mv.setViewName("WEB-INF/updateNotSuccessful.jsp");
			}
			return mv;
		}

		// WHEN Buffet IS DELETED IT WILL REDIRECT TO A RESPECTIVE SUCCESS PAGE.
		@RequestMapping(path = "delete.do", params = "buffetIdDelete", method = RequestMethod.POST)
		public ModelAndView deleteBuffet(Buffets buffet, int buffetIdDelete) {
			boolean buffetDelete = buffetDAO.deleteBuffet(buffetIdDelete);
			System.out.println(buffetDelete); // test to see what buffetDelete is returning. If false should redirect to not successful.
			ModelAndView mv = new ModelAndView();
			if (buffetDelete) {
				mv.setViewName("WEB-INF/updateSuccessful.jsp");
				mv.addObject("result", buffet);
			} else {
				mv.setViewName("WEB-INF/updateNotSuccessful.jsp");
			}
			return mv;
		}

}
