package lab.software.engineering.spring.Reddit.Clone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lab.software.engineering.spring.Reddit.Clone.domain.Comment;
import lab.software.engineering.spring.Reddit.Clone.domain.Link;
import lab.software.engineering.spring.Reddit.Clone.repository.CommentRepository;
import lab.software.engineering.spring.Reddit.Clone.repository.LinkRepository;

@SpringBootApplication
@EnableJpaAuditing
public class RedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneApplication.class, args);
	}
	
	//@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started2","https://love2.com");
			linkRepository.save(link);
			
			
			Comment comment = new Comment("This link is awesome1",link);
			commentRepository.save(comment);
			link.addComment(comment);
		
			System.out.println("We inserted a link and a comment");
			System.out.println("**********************");
			
			
		};
	}
}
