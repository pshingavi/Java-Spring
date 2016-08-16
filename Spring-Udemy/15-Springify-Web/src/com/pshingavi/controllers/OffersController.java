/**
 * 
 */
package com.pshingavi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pshingavi
 *
 */
@Controller
public class OffersController {

	@RequestMapping("/")
	public String showHome(HttpSession session) {
		session.setAttribute("name", "Preetam");
		return "home";
	}
}
