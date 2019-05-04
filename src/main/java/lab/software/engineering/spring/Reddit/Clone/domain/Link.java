package lab.software.engineering.spring.Reddit.Clone.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import lab.software.engineering.spring.Reddit.Clone.service.BeanUtil;
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
	@NotEmpty(message = "Please enter a title.")
	private String title;

	@NonNull
	@NotEmpty(message = "Please enter a url.")
	@URL(message = "Please enter a valid url.")
	private String url;

	// comments
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Link() {

	}

	public Link(@NonNull String title, @NonNull String url) {
		this.title = title;
		this.url = url;
	}

	public Link(Long id, @NonNull String title, @NonNull String url, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.comments = comments;
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

	public String getDomainName() throws URISyntaxException {
		URI uri = new URI(this.url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public String getPrettyTime() {
		PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
		return pt.format(convertToDateViaInstant(getCreationDate()));
	}

	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

}
