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

import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.service.PedidoItemService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(PedidoItemController.class)
public class PedidoItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PedidoItemService pedidoItemService;
	

	@Test
	public void testController1() throws Exception {
		
		when(pedidoItemService.findById(Mockito.anyLong())).thenReturn(getPedidoItemDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/api/pedidoItens/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idItem").value(1L));
	}
	
	@Test
	public void testController2() throws Exception {
		
		when(pedidoItemService.findById(Mockito.anyLong())).thenReturn(getPedidoItemDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/api/pedidoItens/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
	}
	
	public PedidoItemDto getPedidoItemDto() {
		return new PedidoItemDto(1L);
	}

}
