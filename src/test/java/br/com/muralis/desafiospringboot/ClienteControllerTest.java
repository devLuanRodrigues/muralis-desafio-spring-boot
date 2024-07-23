package br.com.muralis.desafiospringboot;

import br.com.muralis.desafiospringboot.application.dto.ClienteDTO;
import br.com.muralis.desafiospringboot.application.mapper.ClienteMapper;
import br.com.muralis.desafiospringboot.application.service.ClienteService;
import br.com.muralis.desafiospringboot.domain.model.Cliente;
import br.com.muralis.desafiospringboot.infrastructure.controller.ClienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteMapper clienteMapper;

    @Test
    public void testGetAllClientes() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);

        when(clienteService.obterTodosClientes()).thenReturn(Arrays.asList(cliente));
        when(clienteMapper.toClienteDTOs(any())).thenReturn(Arrays.asList(clienteDTO));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));

        verify(clienteService, times(1)).obterTodosClientes();
        verify(clienteMapper, times(1)).toClienteDTOs(any());
    }

    @Test
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);

        when(clienteService.obterClientePorId(1L)).thenReturn(Optional.of(cliente));
        when(clienteMapper.toClienteDTO(any())).thenReturn(clienteDTO);

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(clienteService, times(1)).obterClientePorId(1L);
        verify(clienteMapper, times(1)).toClienteDTO(any());
    }

    @Test
    public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);

        when(clienteMapper.toCliente(any())).thenReturn(cliente);
        when(clienteService.criarCliente(any())).thenReturn(cliente);
        when(clienteMapper.toClienteDTO(any())).thenReturn(clienteDTO);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Teste\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(clienteMapper, times(1)).toCliente(any());
        verify(clienteService, times(1)).criarCliente(any());
        verify(clienteMapper, times(1)).toClienteDTO(any());
    }

    @Test
    public void testUpdateCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1L);

        when(clienteService.existePorId(1L)).thenReturn(true);
        when(clienteMapper.toCliente(any())).thenReturn(cliente);
        when(clienteService.atualizarCliente(anyLong(), any())).thenReturn(cliente);
        when(clienteMapper.toClienteDTO(any())).thenReturn(clienteDTO);

        mockMvc.perform(put("/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"nome\":\"Teste Atualizado\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(clienteService, times(1)).existePorId(1L);
        verify(clienteMapper, times(1)).toCliente(any());
        verify(clienteService, times(1)).atualizarCliente(anyLong(), any());
        verify(clienteMapper, times(1)).toClienteDTO(any());
    }

    @Test
    public void testDeleteCliente() throws Exception {
        when(clienteService.existePorId(1L)).thenReturn(true);
        doNothing().when(clienteService).deletarCliente(1L);

        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isNoContent());

        verify(clienteService, times(1)).existePorId(1L);
        verify(clienteService, times(1)).deletarCliente(1L);
    }
}
