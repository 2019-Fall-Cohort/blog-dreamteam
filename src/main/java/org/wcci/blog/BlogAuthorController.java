package org.wcci.blog;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class BlogAuthorController {

	@Resource
	BlogAuthorStorage authors;
	
	@RequestMapping("")
	public String getAuhtors(Model model) {
		model.addAttribute("authors", authors.findAllTheBlogAuthors());
		
		return "authors";
		
	}
	
	@RequestMapping("/{id}")
	public String getAuthor(@PathVariable ("id") long id, Model model) {
		model.addAttribute("author", authors.findBlogAuthor(id));
		
		return "author";
		
	}
	
	@PostMapping("/add")
	public String addAuthor(BlogAuthor authorName, Long authorId) {
		BlogAuthor author = authors.findBlogAuthor(authorId);
		authors.add(authorName);
		
		return "redirect:/author/" + authorId;
	}
	
	
}
