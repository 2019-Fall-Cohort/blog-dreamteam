package org.wcci.blog;

import java.time.LocalDateTime;
import java.util.List;

import org.assertj.core.util.Arrays;

public class BlogPost {

	private String blogPostTitle;
	private BlogAuthor blogAuthor;
	private LocalDateTime blogDateTime;
	private BlogGenre blogGenre;
	private String blogBody;
	private List<BlogTag> blogTags;

	
	public BlogPost(String blogPostTitle, BlogAuthor blogAuthor, LocalDateTime blogDateTime,
			BlogGenre blogGenre, String blogBody, BlogTag... blogTags) {
		this.blogPostTitle = blogPostTitle;
		this.blogAuthor = blogAuthor;
		this.blogDateTime = blogDateTime;
		this.blogGenre = blogGenre;
		this.blogBody = blogBody;
		this.blogTags = Arrays.asList(blogTags);
	}


	public String getBlogPostTitle() {
		return blogPostTitle;
	}


	public BlogAuthor getBlogAuthor() {
		return blogAuthor;
	}


	public LocalDateTime getBlogDateTime() {
		return blogDateTime;
	}


	public BlogGenre getBlogGenre() {
		return blogGenre;
	}


	public String getBlogBody() {
		return blogBody;
	}


	public List<BlogTag> getBlogTags() {
		return blogTags;
	}
	
}
