package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogTagStorage {
	@Autowired
	BlogTagRepository blogTagRepo;
	
	public BlogTag add(BlogTag blogTagToAdd) {
		return blogTagRepo.save(blogTagToAdd);	
	}
	public BlogTag findBrewingCompany(Long id) {
		return blogTagRepo.findById(id).get();
	}

	public Iterable<BlogTag> findAllTheCompanies() {
		return blogTagRepo.findAll();
	}

}
