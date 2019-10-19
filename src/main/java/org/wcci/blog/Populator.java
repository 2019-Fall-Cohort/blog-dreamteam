package org.wcci.blog;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
	@Autowired
	private BlogPostStorage blogPostStorage;
	@Autowired
	private BlogGenreStorage blogGenreStorage;
	@Autowired
	private BlogAuthorStorage blogAuthorStorage;
	@Autowired
	private BlogTagStorage blogTagStorage;

	@Override
	public void run(String... args) throws Exception {

		BlogGenre genre1 = new BlogGenre("ThisHappened!");
		BlogGenre genre2 = new BlogGenre("Weather");
		BlogGenre genre3 = new BlogGenre("SeeTheSights");
		BlogGenre genre4 = new BlogGenre("Question");
		BlogGenre genre5 = new BlogGenre("TIL");
		
		BlogAuthor author1 = new BlogAuthor("Owen Oak");
		BlogAuthor author2 = new BlogAuthor("Fred Ficus");
		BlogAuthor author3 = new BlogAuthor("Reginald Redwood");
		BlogAuthor author4 = new BlogAuthor("Peter Pine");
		BlogAuthor author5 = new BlogAuthor("Sissy Sassafras");
		BlogAuthor author6 = new BlogAuthor("Frank Fir");
		BlogAuthor author7 = new BlogAuthor("Spartacus Spruce");
		
		
		BlogTag tag1 = new BlogTag("stpd sqrlls");
		BlogTag tag2 = new BlogTag("sun LUV");
		BlogTag tag3 = new BlogTag("anthr nail");
		BlogTag tag4 = new BlogTag("called to axtion");
		
		blogGenreStorage.addBlogGenre(genre1);
		blogGenreStorage.addBlogGenre(genre2);
		blogGenreStorage.addBlogGenre(genre3);
		blogGenreStorage.addBlogGenre(genre4);
		blogGenreStorage.addBlogGenre(genre5);
		
		blogAuthorStorage.addBlogAuthor(author1);
		blogAuthorStorage.addBlogAuthor(author2);
		blogAuthorStorage.addBlogAuthor(author3);
		blogAuthorStorage.addBlogAuthor(author4);
		blogAuthorStorage.addBlogAuthor(author5);
		blogAuthorStorage.addBlogAuthor(author6);
		blogAuthorStorage.addBlogAuthor(author7);
		
		blogTagStorage.addBlogTag(tag1);
		blogTagStorage.addBlogTag(tag2);
		blogTagStorage.addBlogTag(tag3);
		blogTagStorage.addBlogTag(tag4);

		BlogPost post1 = new BlogPost("Ate my nuts AGAIN", author1, LocalDateTime.now(), genre1, "Those pesky squirrels were back. You know the ones! THEY TOOK EVERYTHING!!! I don't even know what they're doing with them...storing them for the apocolypse??", tag1);
		BlogPost post2 = new BlogPost("Is it Christmas already?", author6, LocalDateTime.now(), genre4, "Well...I've watched all my older brothers go, and I'm feeling pretty good about being picked this year!", tag4);
		BlogPost post3 = new BlogPost("So Breeeezy!!!", author5, LocalDateTime.now(), genre2, "Guuurls!! I'm loosing leaves with this WIND!!!!", tag2);
		BlogPost post4 = new BlogPost("I am your shelter!", author3, LocalDateTime.now(), genre1, "The neighbor kids have expanded their tree house. I'm honored to be their shelter!", tag3);
		BlogPost post5 = new BlogPost("Yawn!", author2, LocalDateTime.now(), genre3, "The lady gave me another sip of water today. Why am I here? Doesn't she know that I should be OUTSIDE?!?!", tag2);
		BlogPost post6 = new BlogPost("STICKY", author4, LocalDateTime.now(), genre5, "I overheard the man in the overalls talking about 'baseball bats'. I finally understand why he takes my tar!!!!", tag4);
		BlogPost post7 = new BlogPost("The War Continues", author7, LocalDateTime.now(), genre1, "It seems the chipmunks have fortified their lair with my needles.  The squirrels are NOT pleased!", tag1);
		
		blogPostStorage.add(post1);
		blogPostStorage.add(post2);
		blogPostStorage.add(post3);
		blogPostStorage.add(post4);
		blogPostStorage.add(post5);
		blogPostStorage.add(post6);
		blogPostStorage.add(post7);
	
	}

}
