/**
 * 
 */
package com.pshingavi.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pshingavi
 *
 */
@Controller
public class OffersController {

	/*@RequestMapping("/")
	public ModelAndView showHome() {
		// ModelAndView is only for the request scope
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		model.put("name", "<b>Preetam</b>");	// This will be interpreted as bold tags in HTML
		return mv;
	}*/
	
	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("name", "Preetam");
		return "home";
	}
}
