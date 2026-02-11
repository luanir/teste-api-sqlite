package com.luan.testesqlite.controller;

import com.luan.testesqlite.service.ItemService;
import com.luan.testesqlite.model.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")// Permite requisições de qualquer Origem, pode se colocar uma URL especifica
@RestController //Indica que esta classe é um Controller REST (retorna JSON, não páginas HTML)
@RequestMapping("/itens")//Define rota base da API
//Exemplo: http://localhost:8080/itens

public class ItemController {

	@Autowired
	//Injeção de dependência: o Spring cria e gerencia o ItemService
	private ItemService itemService;
	//Permite acessar: controller -> service -> repository -> model
	
	@GetMapping
	//Mapeia requisições HTTP GET para "/itens"
	public List<Item> listarTudo(){
		//Método que retorna toda a lista de itens

		return itemService.listarTudo();
		//Chama o método listarTudo() da camada Service
		//Retorna uma lista de produtos em formato JSON
	}
	
	@PostMapping
	//Mapeia requisições HTTP Post para "/itens"
	public Item salvar(@RequestBody Item item) {
		//@RequestBody converte o JSON recebido no corpo da requisição
		// em um objeto Item
		
		return itemService.salvar(item);
		//Envia o  item para o Service salvar no banco de dados
		//Retorna o produto salvo (já com ID gerado)
	}
	
	@PutMapping("/{id}") 
	//Mapeia requisições HTTP Put para "/itens"
	public Item atualizar(@PathVariable Long id, @RequestBody Item item) {
		//@PathVariable captura o ID da URL
		//@RequestBody recebe os novos dados do produto via JSON
		
		return itemService.atualizar(id, item);
		//atualiza o produto com base no ID informado
	}

	@PostMapping("/salvarLista")
	public List<Item> salvarLista(@RequestBody List<Item> itens){
		return itemService.salvarLista(itens);
	} //Salva todos os produtos colocados no POSTMAN
	
	@DeleteMapping("/{id:\\d+}")
	public void deletar(@PathVariable Long id) {
		itemService.deletar(id);
	}
	
	@GetMapping("/{id:\\d+}")
	public Optional<Item> findById(@PathVariable Long id) {
		return itemService.findById(id);
	}
}
