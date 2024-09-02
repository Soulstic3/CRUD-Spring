package contato.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contato.entity.Contato;
import contato.repository.ContatoRepository;


@RestController
public class ContatoController {
	@Autowired
	private ContatoRepository contatoRepository;
	
	@PostMapping("/salvarContato")
	public String saveContato(@RequestBody Contato contato) {
		contatoRepository.save(contato);
		return "Contato Salvo!";
	}
	
	@GetMapping("/contato")
	public List<Contato> getContatos(){
		return contatoRepository.findAll();
	}
	
	@PutMapping("/atualizarContato/{id}")
	public ResponseEntity<Contato> updateContatoById(@PathVariable Long id, @RequestBody Contato newContatoData) {
		Optional <Contato> oldcontatoData = contatoRepository.findById(id);
		
		if (oldcontatoData.isPresent()) {
			Contato updatedContatoData = oldcontatoData.get();
			updatedContatoData.setName(newContatoData.getNome());
			updatedContatoData.setEmail(newContatoData.getEmail());
			
			Contato contatoObj = contatoRepository.save(updatedContatoData);
			return new ResponseEntity<>(contatoObj, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping ("/deleteContatoById/{id}")
	public ResponseEntity<HttpStatus> deleteContatoById(@PathVariable Long id) {
		contatoRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}