package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogAuthorStorage {
	@Autowired
	BlogAuthorRepository blogAuthorRepo;

	public BlogAuthor add(BlogAuthor blogAuthorToAdd) {
		return blogAuthorRepo.save(blogAuthorToAdd);

	}

	public BlogAuthor findBlogAuthor(Long id) {
		return blogAuthorRepo.findById(id).get();
	}

	public Iterable<BlogAuthor> findAllTheBlogAuthors() {
		return blogAuthorRepo.findAll();
	}

}
