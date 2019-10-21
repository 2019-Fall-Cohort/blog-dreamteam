package org.wcci.blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("all_posts")
	public String getAllBlogPosts(Model model) {
		model.addAttribute("posts", postStorage.findAllTheBlogPosts());
		return "posts";
	}
	
	@GetMapping("/add_post")
	public String getAddReview(Model model) {
		model.addAttribute("authors", authorStorage.findAllTheBlogAuthors());
		model.addAttribute("genres", genreStorage.findAllTheBlogGenres());
		model.addAttribute("tags", tagStorage.findAllTheBlogTags());
		return "add_post";
	}
	
	@PostMapping("/add")
	public String addPost(String blogPostTitle, Long blogAuthorId, Long blogGenreId, String blogBody, Long... blogTagList) {
		BlogAuthor author = authorStorage.findBlogAuthor(blogAuthorId);
		LocalDateTime dateTime = LocalDateTime.now();
		BlogGenre genre = genreStorage.findBlogGenre(blogGenreId);
		List<BlogTag> tags = new ArrayList<BlogTag>();
		Long blogPostId;
		if (blogTagList != null ) {
			for (Long id : blogTagList) {
				tags.add(tagStorage.findBlogTag(id));
			}
			BlogPost postToAdd = new BlogPost(blogPostTitle, author, dateTime, genre, blogBody, tags);
			postStorage.add(postToAdd);
			blogPostId = postToAdd.getId();
		} else {
			BlogPost postToAdd = new BlogPost(blogPostTitle, author, dateTime, genre, blogBody);
			postStorage.add(postToAdd);
			blogPostId = postToAdd.getId();
		}
		return "redirect: all_posts" + blogPostId;
	}
	

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		BlogPost post = postStorage.findBlogPost(id);
		model.addAttribute("post", post);
		return "post";

	}

}