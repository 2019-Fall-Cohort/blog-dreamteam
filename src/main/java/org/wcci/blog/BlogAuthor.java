package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BlogAuthor {
	@Id
	@GeneratedValue
	private Long id;
	private String blogAuthorName;
	@OneToMany (mappedBy = "blogAuthor")
	private List<BlogPost> blogPosts;
	
	public BlogAuthor () {
	}

	public BlogAuthor(String name) {
		this.blogAuthorName = name;
	}

	public String getBlogAuthorName() {
		return blogAuthorName;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
}
