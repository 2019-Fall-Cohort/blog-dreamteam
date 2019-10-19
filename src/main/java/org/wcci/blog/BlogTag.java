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
	@ManyToMany(mappedBy = "blogTags")
	private List<BlogPost> blogPosts;
	
	public BlogTag(String name) {
		this.blogTagName = name;
	}
	
	public void addBlogPostToTag(BlogPost blogPostToAdd) {
		blogPosts.add(blogPostToAdd);
	}
	public String getBlogTagName() {
		return blogTagName;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BlogTag [id=" + id + ", blogTagName=" + blogTagName + ", blogPosts=" + blogPosts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogPosts == null) ? 0 : blogPosts.hashCode());
		result = prime * result + ((blogTagName == null) ? 0 : blogTagName.hashCode());
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
		BlogTag other = (BlogTag) obj;
		if (blogPosts == null) {
			if (other.blogPosts != null)
				return false;
		} else if (!blogPosts.equals(other.blogPosts))
			return false;
		if (blogTagName == null) {
			if (other.blogTagName != null)
				return false;
		} else if (!blogTagName.equals(other.blogTagName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
