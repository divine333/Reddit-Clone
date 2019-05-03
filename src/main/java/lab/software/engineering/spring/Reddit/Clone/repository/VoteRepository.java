package lab.software.engineering.spring.Reddit.Clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.software.engineering.spring.Reddit.Clone.domain.Vote;



public interface VoteRepository extends JpaRepository<Vote, Long>{

}
