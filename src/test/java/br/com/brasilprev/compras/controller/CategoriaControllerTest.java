package br.com.brasilprev.compras.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.brasilprev.compras.dto.CategoriaDto;
import br.com.brasilprev.compras.service.CategoriaService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoriaService categoriaService;
	

	@Test
	public void testController1() throws Exception {
		
		when(categoriaService.findById(Mockito.anyLong())).thenReturn(getCategoriaDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/api/categorias/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idCategoria").value(1L));
	}
	
	@Test
	public void testController2() throws Exception {
		
		when(categoriaService.findById(Mockito.anyLong())).thenReturn(getCategoriaDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/api/categorias/{id}", 1L)
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk());
			      
	}
	
	@Test
	public void testController3() throws Exception {
		
		when(categoriaService.insert(Mockito.any())).thenReturn(getCategoriaDto());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/categorias/")
			      .contentType(MediaType.APPLICATION_JSON)
		          .content(" {\"idCategoria\": 1,\"categoria\": \"Brinquedos\"}") 			      
			      .header("Authorization", "Basic dXNlcjoxMjM0NTY=")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.idCategoria").value(1L));
	}
	
	
	public CategoriaDto getCategoriaDto() {
		return new CategoriaDto(1L, "TESTE");
	}

}
