package org.wcci.blog;

import java.util.List;

public class BlogAuthor {
	
	private String blogAuthorName;
	private List<BlogPost> blogPosts;
	
	public BlogAuthor(String name) {
		this.blogAuthorName = name;
	}
}
