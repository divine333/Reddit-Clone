package lab.software.engineering.spring.Reddit.Clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.software.engineering.spring.Reddit.Clone.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
