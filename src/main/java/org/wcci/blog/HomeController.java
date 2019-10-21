package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	BlogAuthorStorage authorStorage;
	@Autowired
	BlogGenreStorage genreStorage;
	@Autowired
	BlogPostStorage postStorage;
	@Autowired
	BlogTagStorage tagStorage;
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		return "index";
	}

}