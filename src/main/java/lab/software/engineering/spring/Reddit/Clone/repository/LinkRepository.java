package lab.software.engineering.spring.Reddit.Clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.software.engineering.spring.Reddit.Clone.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long>{

	
	
}
