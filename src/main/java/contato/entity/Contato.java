package contato.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;

	public String getEmail() {
		return this.email; 
	}

	public String getNome() {
		return this.nome;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
