package org.wcci.blog;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
	
	public BlogPost(String blogPostTitle, BlogAuthor blogAuthor, LocalDateTime blogDateTime,
			BlogGenre blogGenre, String blogBody, List<BlogTag> blogTags) {
		this.blogPostTitle = blogPostTitle;
		this.blogAuthor = blogAuthor;
		this.blogDateTime = blogDateTime;
		this.blogGenre = blogGenre;
		this.blogBody = blogBody;
		this.blogTags = blogTags;
	}

	public BlogPost() {
	}

	public void addBlogTagToBlogPost(BlogTag blogTagToAdd) {
		blogTags.add(blogTagToAdd);
	}
	
	public String getBlogPostTitle() {
		return blogPostTitle;
	}


	public BlogAuthor getBlogAuthor() {
		return blogAuthor;
	}

	public Long getId() {
		return id;
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

	public List<BlogTag> getBlogTag() {
		return blogTags;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", blogPostTitle=" + blogPostTitle + ", blogAuthor=" + blogAuthor
				+ ", blogDateTime=" + blogDateTime + ", blogGenre=" + blogGenre + ", blogBody=" + blogBody
				+ ", blogTags=" + blogTags + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogAuthor == null) ? 0 : blogAuthor.hashCode());
		result = prime * result + ((blogBody == null) ? 0 : blogBody.hashCode());
		result = prime * result + ((blogDateTime == null) ? 0 : blogDateTime.hashCode());
		result = prime * result + ((blogGenre == null) ? 0 : blogGenre.hashCode());
		result = prime * result + ((blogPostTitle == null) ? 0 : blogPostTitle.hashCode());
		result = prime * result + ((blogTags == null) ? 0 : blogTags.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogPost other = (BlogPost) obj;
		if (blogAuthor == null) {
			if (other.blogAuthor != null)
				return false;
		} else if (!blogAuthor.equals(other.blogAuthor))
			return false;
		if (blogBody == null) {
			if (other.blogBody != null)
				return false;
		} else if (!blogBody.equals(other.blogBody))
			return false;
		if (blogDateTime == null) {
			if (other.blogDateTime != null)
				return false;
		} else if (!blogDateTime.equals(other.blogDateTime))
			return false;
		if (blogGenre == null) {
			if (other.blogGenre != null)
				return false;
		} else if (!blogGenre.equals(other.blogGenre))
			return false;
		if (blogPostTitle == null) {
			if (other.blogPostTitle != null)
				return false;
		} else if (!blogPostTitle.equals(other.blogPostTitle))
			return false;
		if (blogTags == null) {
			if (other.blogTags != null)
				return false;
		} else if (!blogTags.equals(other.blogTags))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
