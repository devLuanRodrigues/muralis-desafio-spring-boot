package br.com.muralis.desafiospringboot;

import br.com.muralis.desafiospringboot.application.service.ClienteService;
import br.com.muralis.desafiospringboot.domain.model.Cliente;
import br.com.muralis.desafiospringboot.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObterTodosClientes() {
        List<Cliente> clientes = Arrays.asList(new Cliente(), new Cliente());
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.obterTodosClientes();

        assertEquals(2, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testObterClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.obterClientePorId(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    public void testCriarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.criarCliente(cliente);

        assertEquals("Teste", result.getNome());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testAtualizarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Atualizado");
        when(clienteRepository.existsById(1L)).thenReturn(true);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteService.atualizarCliente(1L, cliente);

        assertNotNull(result);
        assertEquals("Atualizado", result.getNome());
        verify(clienteRepository, times(1)).existsById(1L);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testAtualizarClienteNaoExistente() {
        Cliente cliente = new Cliente();
        when(clienteRepository.existsById(1L)).thenReturn(false);

        Cliente result = clienteService.atualizarCliente(1L, cliente);

        assertNull(result);
        verify(clienteRepository, times(1)).existsById(1L);
        verify(clienteRepository, times(0)).save(cliente);
    }

    @Test
    public void testDeletarCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.deletarCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testExistePorId() {
        when(clienteRepository.existsById(1L)).thenReturn(true);

        boolean result = clienteService.existePorId(1L);

        assertTrue(result);
        verify(clienteRepository, times(1)).existsById(1L);
    }
}
