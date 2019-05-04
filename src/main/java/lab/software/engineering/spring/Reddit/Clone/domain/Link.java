package lab.software.engineering.spring.Reddit.Clone.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
public class Link extends Auditable {

	@Id
	@GeneratedValue
	private Long id;

	
	@NonNull
	private String title;

	
	@NonNull
	private String url;

	// comments
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<>();


	public Link(@NonNull String title, @NonNull String url) {
		this.title = title;
		this.url = url;
	}

	
	public void addComment(Comment comment) {
		comments.add(comment);
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	
}
