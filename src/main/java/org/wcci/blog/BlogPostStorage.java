package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogPostStorage {
	@Autowired
	BlogPostRepository blogPostRepo;
	

	public BlogPost add(BlogPost blogPostToAdd) {
		return blogPostRepo.save(blogPostToAdd);
	}
	
	public BlogPost findBlogPost(Long id) {
		return blogPostRepo.findById(id).get();
	}

	public Iterable<BlogPost> findAllTheCompanies() {
		return blogPostRepo.findAll();
	}

}
