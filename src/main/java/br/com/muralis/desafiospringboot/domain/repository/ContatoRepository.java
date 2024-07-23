package br.com.muralis.desafiospringboot.domain.repository;

import br.com.muralis.desafiospringboot.domain.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}


