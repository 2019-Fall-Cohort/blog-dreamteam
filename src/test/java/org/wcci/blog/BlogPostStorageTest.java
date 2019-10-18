package org.wcci.blog;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

public class BlogPostStorageTest {
	
	@Test
	public void shouldBeAbleToAddBlogPostToStorage() {
		BlogPostStorage underTestPostStorage = new BlogPostStorage();
		
		BlogPost underTestBlogPost = new BlogPost("Brian Smells", new BlogAuthor("Brian"), LocalDateTime.now(), new BlogGenre("Smells"), "Goober", new BlogTag("Stinky"));
		underTestPostStorage.add(underTestBlogPost);
		
		assertThat(underTestPostStorage, contains(underTestBlogPost));
		
	}

}

//@Test
//public void shouldBeAbleToAddBlogPostToStorage() {
//	BlogAuthorStorage underTestAuthorStorage = new BlogAuthorStorage();
//	BlogGenreStorage underTestGenreStorage = new BlogGenreStorage();
//	BlogPostStorage underTestPostStorage = new BlogPostStorage();
//	BlogTagStorage underTestTagStorage = new BlogTagStorage();
//	
//	BlogPost underTestBlogPost = new BlogPost("Brian Smells", new BlogAuthor("Brian"), LocalDateTime.now(), new BlogGenre("Smells"), "Goober", new BlogTag("Stinky"));
//	underTestPostStorage.add(underTestBlogPost);
//	
//	BlogAuthor underTestBlogAuthor = new BlogAuthor("Brian");
//	underTestAuthorStorage.add(underTestBlogAuthor);
//	
//	BlogGenre underTestBlogGenre = new BlogGenre("Hilarious");
//	underTestGenreStorage.add(underTestBlogGenre);
//	
//	BlogTag underTestBlogTag = new BlogTag ("Woody");
//	underTestTagStorage.add(underTestBlogTag);
//	
//	assertThat(underTestPostStorage, contains(underTestBlogPost));
//	assertThat(underTestAuthorStorage, contains(underTestBlogAuthor));
//	assertThat(underTestGenreStorage, contains(underTestBlogGenre));
//	assertThat(underTestTagStorage, contains(underTestBlogTag));
//	
}
