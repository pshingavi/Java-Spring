/**
 * 
 */
package com.pshingavi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pshingavi
 *
 */
@Controller
public class OffersController {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
}
