package org.wcci.blog;

import java.util.List;

public class BlogGenre {
	
	private String blogGenreName;
	private List<BlogPost> blogPosts;

	public BlogGenre(String name) {
		this.blogGenreName = name;
	}
}
