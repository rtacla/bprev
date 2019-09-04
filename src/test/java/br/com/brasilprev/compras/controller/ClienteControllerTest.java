package br.com.brasilprev.compras.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.service.ClienteService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClienteService clienteService;
	

	@Test
	public void testController1() throws Exception {
		
		when(clienteService.findById(Mockito.anyLong())).thenReturn(getClienteDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/api/clientes/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idCliente").value(1L));
	}
	
	@Test
	public void testController2() throws Exception {
		
		when(clienteService.findById(Mockito.anyLong())).thenReturn(getClienteDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/api/clientes/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
	}
	
	
	@Test
	public void testController3() throws Exception {
		
		when(clienteService.insert(Mockito.any())).thenReturn(getClienteDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/clientes/")
			      .contentType(MediaType.APPLICATION_JSON)
		          .content(" {\"idCliente\": 1,\"nome\": \"XXX\"}") 			      
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idCliente").value(1L));
	}	
	
	
	
	public ClienteDto getClienteDto() {
		return new ClienteDto(1L, "TESTE");
	}

}
