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

import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.service.ProdutoService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProdutoService produtoService;
	

	@Test
	public void testController1() throws Exception {
		
		when(produtoService.findById(Mockito.anyLong())).thenReturn(getProdutoDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/api/produtos/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idProduto").value(1L));
	}
	
	@Test
	public void testController2() throws Exception {
		
		when(produtoService.findById(Mockito.anyLong())).thenReturn(getProdutoDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/api/produtos/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
	}
	
	
	@Test
	public void testController3() throws Exception {
		
		when(produtoService.insert(Mockito.any())).thenReturn(getProdutoDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/produtos/")
			      .contentType(MediaType.APPLICATION_JSON)
		          .content(" {\"idProduto\": 1,\"produto\": \"XXX\"}") 			      
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idProduto").value(1L));
	}	
	
	
	public ProdutoDto getProdutoDto() {
		return new ProdutoDto(1L, "TESTE");
	}

}
