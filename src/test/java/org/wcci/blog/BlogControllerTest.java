package org.wcci.blog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class BlogControllerTest {
	@Mock
	Model model;
	@Mock
	BlogPostStorage mockPostStorage;
	
	@InjectMocks
	HomeController underTest;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void displayAllReviews() throws Exception {
		String viewName = underTest.getPosts(model);
		assertThat(viewName, is("posts"));
	}
	
	@Test
	public void displayIndex() throws Exception {
		String viewName = underTest.welcomePage(model);
		assertThat(viewName, is("index"));
	}
	
	@Test
	public void displayAllReviewsAddReviewsToTheModel() throws Exception {
		BlogPost mockPost = mock(BlogPost.class);
		when(mockPostStorage.findAllTheBlogPosts()).thenReturn(Collections.singletonList(mockPost));
		underTest.getPosts(model);
		verify(model).addAttribute("posts", Collections.singletonList(mockPost));
	}
}
