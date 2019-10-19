package org.wcci.blog;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genre")
public class BlogGenreController {

	@Resource
	BlogGenreStorage genres;
	
	@RequestMapping("")
	public String getGenres(Model model) {
		model.addAttribute("genres", genres.findAllTheBlogGenres());
		
		return "genres";
		
	}
	
	@RequestMapping("/{id}")
	public String getGenre(@PathVariable ("id") long id, Model model) {
		model.addAttribute("genre", genres.findBlogGenre(id));
		
		return "genre";
		
	}
	
	@PostMapping("/add")
	public String addGenre(BlogGenre genreName, Long genreId) {
		BlogGenre genre = genres.findBlogGenre(genreId);
		genres.add(genreName);
		
		return "redirect:/genre/" + genreId;
	}
}
	