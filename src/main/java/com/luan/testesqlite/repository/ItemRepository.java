package com.luan.testesqlite.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.testesqlite.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	//buscar por nome
	List<Item> findByNome(String nome);
	List<Item> findByNomeContaining (String nome);
	List<Item> findByNomeAndStatus(String nome, String status);
    List<Item> findByNomeStartingWith(String prefix);
    
	
	
	//busca por preço
	List<Item> findByValor(Double valor);
	 List<Item> findByValorGreaterThan(Double valor);
     List<Item> findByValorLessThan(Double valor);
     
  // Usando anottation @Query para obter total de preços
     
     @Query("SELECT SUM(p.valor) FROM Item p")
     Double findTotalValor();
     
     // Buscas por quantidade de produto
     List<Item> findByQuantidade(Integer quantidade);
     List<Item> findByQuantidadeLessThan(Integer quantidade);
     List<Item> findByQuantidadeGreaterThan(Integer quantidade);
     
     // Buscas por valor e status
     List<Item> findByStatus(String status);
     List<Item> findByStatusIsNull();
     List<Item> findByValorAndStatus(Double valor, String status); 
}
