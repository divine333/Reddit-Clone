package lab.software.engineering.spring.Reddit.Clone.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Link {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String url;

	// comments
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<>();

}
