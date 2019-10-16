package org.wcci.blog;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class BlogPostStorageTest {
	
	@Test
	public void instantiatesStorage() {
		BlogAuthorStorage underTestAuthorStorage = new BlogAuthorStorage();
		BlogGenreStorage underTestGenreStorage = new BlogGenreStorage();
		BlogPostStorage underTestPostStorage = new BlogPostStorage();
		BlogTagStorage underTestTagStorage = new BlogTagStorage();
		
		BlogPost underTestBlogPost = new BlogPost("Brian Smells", new BlogAuthor("Brian"), LocalDateTime.now(), new BlogGenre("Smells"), "Sexy Body", new BlogTag("Stinky"));
		underTestPostStorage.add(underTestBlogPost);
		
		BlogAuthor underTestBlogAuthor = new BlogAuthor("Brian");
		underTestAuthorStorage.add(underTestBlogAuthor);
		
	}

}
