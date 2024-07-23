package br.com.muralis.desafiospringboot.domain.repository;

import br.com.muralis.desafiospringboot.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

