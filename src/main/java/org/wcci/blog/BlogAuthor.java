package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogAuthor {
	@Id
	@GeneratedValue
	private Long id;
	private String blogAuthorName;
	private List<BlogPost> blogPosts;
	
	public BlogAuthor(String name) {
		this.blogAuthorName = name;
	}
}
