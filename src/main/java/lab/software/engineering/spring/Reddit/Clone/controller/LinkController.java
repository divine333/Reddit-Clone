package lab.software.engineering.spring.Reddit.Clone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.software.engineering.spring.Reddit.Clone.domain.Link;
import lab.software.engineering.spring.Reddit.Clone.repository.LinkRepository;

@RestController
@RequestMapping("/links")
public class LinkController {
	
	
	private LinkRepository linkRepository;

	
	public LinkController(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
	//list
	@GetMapping("/")
	public List<Link> list(){
		return linkRepository.findAll();
	}
	
	//crud
	@PostMapping("/create")
	public Link create(@ModelAttribute Link link) {
		return linkRepository.save(link);
	}
	
	@GetMapping("/{id}")
	public Optional<Link> read(@PathVariable Long id) {
		return linkRepository.findById(id);
	}
	
	@PutMapping("/{id}")
		public Link update(@PathVariable long id,@ModelAttribute Link link) {
		//get the link id
		return linkRepository.save(link);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		linkRepository.deleteById(id);
	}
}
