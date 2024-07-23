package br.com.muralis.desafiospringboot.application.mapper;

import br.com.muralis.desafiospringboot.application.dto.ContatoDTO;
import br.com.muralis.desafiospringboot.domain.model.Contato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContatoMapper {
    ContatoDTO toDTO(Contato contato);
    Contato toEntity(ContatoDTO contatoDTO);
}

