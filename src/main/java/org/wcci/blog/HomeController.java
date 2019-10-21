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
		return "redirect:/posts/" + blogPostId;
	}
	
	@GetMapping("/author")
	public String getAuhtors(Model model) {
		model.addAttribute("authors", authorStorage.findAllTheBlogAuthors());
		
		return "";
		
	}
	
	@GetMapping("/author/{id}")
	public String getAuthor(@PathVariable ("id") long id, Model model) {
		model.addAttribute("author", authorStorage.findBlogAuthor(id));
		
		return "";
		
	}
	
	@PostMapping("/author/add")
	public String addAuthor(BlogAuthor authorName, Long authorId) {
		//BlogAuthor author = authors.findBlogAuthor(authorId);
		authorStorage.addBlogAuthor(authorName);
		
		return "redirect:add_post";
	}
	
	@GetMapping("/genre")
	public String getGenres(Model model) {
		model.addAttribute("genres", genreStorage.findAllTheBlogGenres());
		
		return "posts";
		
	}
	
	@GetMapping("/genre/{id}")
	public String getGenre(@PathVariable ("id") long id, Model model) {
		model.addAttribute("genre", genreStorage.findBlogGenre(id));
		
		return "posts";
		
	}
	
	@PostMapping("/genre/add")
	public String addGenre(BlogGenre genreName, Long genreId) {
		//BlogGenre genre = genres.findBlogGenre(genreId);
		genreStorage.addBlogGenre(genreName);
		
		return "redirect:/add_post/";
	}
	
	@GetMapping("/posts")
	public String getPosts(Model model) {
		model.addAttribute("posts", postStorage.findAllTheBlogPosts());

		return "posts";

	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		BlogPost post = postStorage.findBlogPost(id);
		model.addAttribute("post", post);
		return "post";

	}

	@PostMapping("/post/add")
	public String addPost(String blogPostTitle, BlogAuthor blogAuthor, LocalDateTime blogDateTime, BlogGenre blogGenre,
		   String blogBody, Long postId, BlogTag... blogTags) {
		//BlogPost post = posts.findBlogPost(postId);
		postStorage.add(new BlogPost (blogPostTitle, blogAuthor, blogDateTime, blogGenre, blogBody, blogTags));

		return "redirect:/post/" + postId;
	}
	
	@GetMapping("/tag")
	public String getTags(Model model) {
		model.addAttribute("tags", tagStorage.findAllTheBlogTags());

		return "posts";

	}

	@GetMapping("/tag/{id}")
	public String getTag(@PathVariable("id") long id, Model model) {
		model.addAttribute("tag", tagStorage.findBlogTag(id));

		return "post";

	}

	@PostMapping("/tag/add")
	public String addTag(BlogTag blogTagName, Long tagId) {
	//	BlogTag tag = tags.findBlogTag(tagId);
		tagStorage.addBlogTag(blogTagName);

		return "redirect:/add_post/";
	}
	
	
}