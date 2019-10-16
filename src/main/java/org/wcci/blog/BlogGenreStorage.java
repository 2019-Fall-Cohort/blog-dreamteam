package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogGenreStorage {
	@Autowired
	BlogGenreRepository blogGenreRepo;

	public BlogGenre add(BlogGenre blogGenreToAdd) {
		return blogGenreRepo.save(blogGenreToAdd);
		
	}

}
