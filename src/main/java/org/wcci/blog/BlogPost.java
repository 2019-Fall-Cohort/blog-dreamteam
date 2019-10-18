package org.wcci.blog;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BlogPost {
	@Id
	@GeneratedValue
	private Long id;
	private String blogPostTitle;
	@ManyToOne
	private BlogAuthor blogAuthor;
	private LocalDateTime blogDateTime;
	@ManyToOne
	private BlogGenre blogGenre;
	private String blogBody;
	@ManyToMany
	private BlogTag blogTag;

	
	public BlogPost(String blogPostTitle, BlogAuthor blogAuthor, LocalDateTime blogDateTime,
			BlogGenre blogGenre, String blogBody, BlogTag blogTag) {
		this.blogPostTitle = blogPostTitle;
		this.blogAuthor = blogAuthor;
		this.blogDateTime = blogDateTime;
		this.blogGenre = blogGenre;
		this.blogBody = blogBody;
		this.blogTag = blogTag;
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

	public BlogTag getBlogTag() {
		return blogTag;
	}
	
}
