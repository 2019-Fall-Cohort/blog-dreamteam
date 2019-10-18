package org.wcci.blog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BlogTag {
	@Id
	@GeneratedValue
	private Long id;
	private String blogTagName;
	private List<BlogPost> blogPosts;

	public BlogTag(String name) {
		this.blogTagName = name;
	}
}
