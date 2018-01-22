package livraria_spring_demo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import livraria_spring_demo.models.Produto;



@Repository 
@Transactional
public class ProdutoDAO {
	
	// Anotação do spring que vai injetar o entityManager 
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar (Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listar() {
		
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

}