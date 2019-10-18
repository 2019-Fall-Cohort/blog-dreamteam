package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BlogGenre {
	@Id
	@GeneratedValue
	private Long id;
	private String blogGenreName;
	@OneToMany (mappedBy = "blogGenre")
	private List<BlogPost> blogPosts;

	public BlogGenre(String name) {
		this.blogGenreName = name;
	}

	public String getBlogGenreName() {
		return blogGenreName;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
}
