//package org.wcci.blog;
//
//import java.time.LocalDateTime;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/post")
//public class BlogPostController {
//
//	@Resource
//	BlogPostStorage posts;
//
//	@RequestMapping("")
//	public String getPosts(Model model) {
//		model.addAttribute("posts", posts.findAllTheBlogPosts());
//
//		return "posts";
//
//	}
//
//	@RequestMapping("/{id}")
//	public String getPost(@PathVariable("id") long id, Model model) {
//		model.addAttribute("post", posts.findBlogPost(id));
//
//		return "post";
//
//	}
//
//	@PostMapping("/add")
//	public String addPost(String blogPostTitle, BlogAuthor blogAuthor, LocalDateTime blogDateTime, BlogGenre blogGenre,
//		   String blogBody, Long postId, BlogTag... blogTags) {
//		BlogPost post = posts.findBlogPost(postId);
//		posts.add(new BlogPost (blogPostTitle, blogAuthor, blogDateTime, blogGenre, blogBody, blogTags));
//
//		return "redirect:/post/" + postId;
//	}
//}
