package org.wcci.blog;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class BlogPostTest {

	@Test
	public void canCreateNewBlogPost() throws Exception {
		String utBlogPostTitle = "Under Test Blog Post Title";
		BlogAuthor utBlogAuthor = new BlogAuthor("Under Test Blog Author");
		LocalDateTime utBlogDateTime = LocalDateTime.now();
		BlogGenre utBlogGenre = new BlogGenre("This Happened!");
		String utBlogBody = "Long for a grapefruit!";
		BlogTag utBlogTag = new BlogTag("Stpd Sqrls");
		
		BlogPost utBlogPost = new BlogPost(utBlogPostTitle, utBlogAuthor, utBlogDateTime, utBlogGenre, utBlogBody, utBlogTag);
		
		assertEquals(utBlogPost.getBlogPostTitle(),utBlogPostTitle);
	}
}
