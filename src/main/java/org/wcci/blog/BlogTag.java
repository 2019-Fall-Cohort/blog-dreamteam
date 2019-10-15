package org.wcci.blog;

import java.util.List;

public class BlogTag {

	private String blogTagName;
	private List<BlogPost> blogPosts;

	public BlogTag(String name) {
		this.blogTagName = name;
	}
}
