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

	public BlogGenre() {
	}
	
	public BlogGenre(String nameOfBlogGenre) {
		this.blogGenreName = nameOfBlogGenre;
	}
	
	public Long getId() {
		return id;
	}

	public String getBlogGenreName() {
		return blogGenreName;
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}

	@Override
	public String toString() {
		return "BlogGenre [id=" + id + ", blogGenreName=" + blogGenreName + ", blogPosts=" + blogPosts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogGenreName == null) ? 0 : blogGenreName.hashCode());
		result = prime * result + ((blogPosts == null) ? 0 : blogPosts.hashCode());
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
		BlogGenre other = (BlogGenre) obj;
		if (blogGenreName == null) {
			if (other.blogGenreName != null)
				return false;
		} else if (!blogGenreName.equals(other.blogGenreName))
			return false;
		if (blogPosts == null) {
			if (other.blogPosts != null)
				return false;
		} else if (!blogPosts.equals(other.blogPosts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
