package lab.software.engineering.spring.Reddit.Clone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	private String body;

	// link
	@ManyToOne
	private Link link;

}
