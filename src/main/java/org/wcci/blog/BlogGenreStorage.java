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
	public BlogGenre findBlogGenre(Long id) {
		return blogGenreRepo.findById(id).get();
	}

	public Iterable<BlogGenre> findAllTheBlogGenres() {
		return blogGenreRepo.findAll();
	}

}
