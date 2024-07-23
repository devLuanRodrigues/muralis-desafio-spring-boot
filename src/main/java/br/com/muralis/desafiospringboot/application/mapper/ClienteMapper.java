package br.com.muralis.desafiospringboot.application.mapper;

import br.com.muralis.desafiospringboot.application.dto.ClienteDTO;
import br.com.muralis.desafiospringboot.domain.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toClienteDTO(Cliente cliente);
    Cliente toCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> toClienteDTOs(List<Cliente> clientes);
}

