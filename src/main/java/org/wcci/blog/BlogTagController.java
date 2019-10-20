package org.wcci.blog;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class BlogTagController {
	
	@Resource
	BlogTagStorage tags;

	@RequestMapping("")
	public String getTags(Model model) {
		model.addAttribute("tags", tags.findAllTheBlogTags());

		return "posts";

	}

	@RequestMapping("/{id}")
	public String getTag(@PathVariable("id") long id, Model model) {
		model.addAttribute("tag", tags.findBlogTag(id));

		return "post";

	}

	@PostMapping("/add")
	public String addTag(BlogTag blogTagName, Long tagId) {
		BlogTag tag = tags.findBlogTag(tagId);
		tags.addBlogTag(blogTagName);

		return "redirect:/add_post/";
	}

}
