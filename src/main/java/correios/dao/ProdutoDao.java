package correios.dao;

import javax.persistence.EntityManager;

import correios.model.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizaClientes(Produto produto) {
		this.em.merge(produto);
	}
}
