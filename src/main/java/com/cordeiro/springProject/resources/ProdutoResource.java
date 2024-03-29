package com.cordeiro.springProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cordeiro.springProject.domain.Produto;
import com.cordeiro.springProject.dto.ProdutoDTO;
import com.cordeiro.springProject.resources.utils.URL;
import com.cordeiro.springProject.services.ProdutoService;
@RestController
@RequestMapping("/Produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	@GetMapping("{id}")
	public ResponseEntity<?> find (@PathVariable Integer id){
		Produto obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
		public ResponseEntity<Page<ProdutoDTO>> findPage(
			
			
			@RequestParam(value="categorias",defaultValue="")String name,
			@RequestParam(value="name",defaultValue="")String categorias,
			@RequestParam(value="page",defaultValue="0")Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage,
			@RequestParam(value="OrderBy", defaultValue="nome")String orderBy,
			@RequestParam(value="direction", defaultValue="ASC")String direction) {
			String nomeDecoded = URL.decodParam(name);
		 List<Integer> ids = URL.decodeIntList(categorias);
			Page<Produto>list =service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
			Page<ProdutoDTO> listDTO =  list.map(obj -> new ProdutoDTO(obj));
			return ResponseEntity.ok().body(listDTO);
		
		}

}
