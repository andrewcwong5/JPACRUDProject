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

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		// Retrieves buffet list, add it to the model.
		ModelAndView mv = new ModelAndView();
//		Buffets buffet = buffetDAO.findById(1);
//		mv.addObject("buffet", buffet);
//		BuffetDAOJpalmpl.List<Buffets> findAll();
		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	}

	@RequestMapping(path = "getBuffet.do", method = RequestMethod.GET)
	public ModelAndView getBuffet(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Buffets buffet = buffetDAO.findById(id);
		mv.addObject("buffet", buffet);
		mv.setViewName("WEB-INF/buffets/show.jsp");

		return mv;
	}
	@RequestMapping(path = "list.do", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		List<Buffets> buffets = buffetDAO.findAll();   
		mv.setViewName("WEB-INF/buffets/show.jsp");
		mv.addObject("buffets", buffets);
		return mv;
	}
	// List
//	String query = "SELECT b FROM Buffets b";
//	List<Buffets> results =
//	  em.createQuery(query, buffet.class)
//	    .getResultList();

	
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
	public ModelAndView createBuffet(@RequestParam Buffets buffet) {
		Buffets addBuffet = buffetDAO.createBuffet(buffet);
		ModelAndView mv = new ModelAndView();
			mv.addObject("buffet", buffet);
			mv.setViewName("WEB-INF/buffets/updatesuccessful.jsp");
		return mv;
	}
	@RequestMapping(path = "update.do", params = "buffetID", method = RequestMethod.POST)
	public ModelAndView updateBuffet(int buffetId, Buffets buffet) {
		Buffets updateBuffet = buffetDAO.updateBuffet(buffetId, buffet);
		ModelAndView mv = new ModelAndView();
		mv.addObject("buffet", updateBuffet);
		return mv;
	}
	@RequestMapping(path = "delete.do", params = "buffetIdDelete", method = RequestMethod.POST)
	public ModelAndView deleteBuffet(Buffets buffet, int buffetIdDelete) {
		boolean buffetDelete = buffetDAO.deleteBuffet(buffetIdDelete);
		System.out.println(buffetDelete); // test to see what buffetDelete is returning. If false should redirect to not
											// successful.
		ModelAndView mv = new ModelAndView();
		if (buffetDelete) {
			mv.setViewName("WEB-INF/buffets/updateSuccessful.jsp");
			mv.addObject("result", buffet);
		} else {
			mv.setViewName("WEB-INF/updateNotSuccessful.jsp");
		}
		return mv;
	}

}
