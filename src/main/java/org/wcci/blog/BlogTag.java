package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class BlogTag {
	@Id
	@GeneratedValue
	private Long id;
	private String blogTagName;
	@ManyToMany
	private List<BlogPost> blogPosts;

	public BlogTag(String name) {
		this.blogTagName = name;
	}

	public String getBlogTagName() {
		return blogTagName;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
}
