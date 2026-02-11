package com.luan.testesqlite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luan.testesqlite.model.Item;
import com.luan.testesqlite.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> listarTudo(){//Lista todos os itens da base de dados
		return itemRepository.findAll();
	}
	
	public Item salvar(Item item) {//Salva o item na base de dados gerando um id Automatico!
		return itemRepository.save(item);
	}
	
	public void deletar (Long id) {//Deleta por ID na base de dados
		itemRepository.deleteById(id);
	}
	
	public Item atualizar(Long id, Item item) {//Atualiza o Item
		if(itemRepository.existsById(id)) {
			item.setId(id);
			return itemRepository.save(item);
		} else {
			throw new RuntimeException("Item não encontrado!");/*  Se você quiser lançar uma exceção propositalmente em Java, use a palavra-chave throw. 
            Isso é útil para indicar que ocorreu um erro em uma condição específica durante a execução do programa.  */
		}
	}
	
	public Optional<Item> findById(Long id){
		return itemRepository.findById(id);
	}
	
	public List<Item> salvarLista(List<Item> itens){ //Usado para salvar muitos de uma vez
		return itemRepository.saveAll(itens);
	}
	
	//Busca DETALHADA POR NOME!
	
	public List<Item> findByNome(String nome){//Acha pelo nome
		return itemRepository.findByNome(nome);
	}
	
	public List<Item> findByNomeContaining(String nome){//Acha pelo oque contém no nome 
		return itemRepository.findByNomeContaining(nome);
	}
	
	public List<Item> findByNomeAndStatus(String nome, String status){
		return itemRepository.findByNomeAndStatus(nome, status);
	}
	
	public List<Item> findByNomeStartingWith(String prefix){
		return itemRepository.findByNomeStartingWith(prefix);
	}
	
	//Busca DETALHADA POR VALOR!
	
	public List<Item> findByValor(Double valor){
		return itemRepository.findByValor(valor);
	}
	
	public List<Item> findByValorGreaterThan(Double valor){
		return itemRepository.findByValorGreaterThan(valor);
	}
	
	public List<Item> findByValorLessThan(Double valor){
		return itemRepository.findByValorLessThan(valor);
	}
	
	public Double findTotalValor() {
		return itemRepository.findTotalValor();
	}
	
	//Busca DETALHADA POR QUANTIDADE!
	
	public List<Item> findByQuantidade(Integer quantidade){
		return itemRepository.findByQuantidade(quantidade);
	}
	
	public List<Item> findByQuantidadeLessThan(Integer quantidade){
		return itemRepository.findByQuantidadeLessThan(quantidade);
	}
	
	public List<Item> findByQuantidadeGreaterThan(Integer quantidade){
		return itemRepository.findByQuantidadeGreaterThan(quantidade);
	}
	
	//Busca DETALHADA POR VALOR E STATUS!
	
	public List<Item> findByStatus(String status){
		return itemRepository.findByStatus(status);
	}
	
	public List<Item> findByStatusIsNull(){
		return itemRepository.findByStatusIsNull();
	}
	
	public List<Item> findByValorAndStatus(Double valor, String status){
		return itemRepository.findByValorAndStatus(valor, status);
	}
	
	public Long count() {
		return itemRepository.count();
	}
}