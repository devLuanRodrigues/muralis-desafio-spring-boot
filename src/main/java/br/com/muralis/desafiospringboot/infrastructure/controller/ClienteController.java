package br.com.muralis.desafiospringboot.infrastructure.controller;

import br.com.muralis.desafiospringboot.application.dto.ClienteDTO;
import br.com.muralis.desafiospringboot.application.mapper.ClienteMapper;
import br.com.muralis.desafiospringboot.application.service.ClienteService;
import br.com.muralis.desafiospringboot.domain.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteService.obterTodosClientes();
        return clienteMapper.toClienteDTOs(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obterClientePorId(id);
        return cliente.map(value -> ResponseEntity.ok(clienteMapper.toClienteDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toCliente(clienteDTO);
        Cliente clienteCriado = clienteService.criarCliente(cliente);
        return clienteMapper.toClienteDTO(clienteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        if (!clienteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clienteMapper.toCliente(clienteDTO);
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(clienteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (!clienteService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
