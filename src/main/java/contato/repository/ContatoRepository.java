package contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import contato.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}