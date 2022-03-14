package correios.controller;

import javax.persistence.EntityManager;

import correios.dao.ProdutoDao;
import correios.model.Produto;
import correios.util.JPAUtil;

public class ProdutoController {
	
	private ProdutoDao produtoDao;
	private EntityManager em;
	
	public ProdutoController() {
		this.em = JPAUtil.getEntityManager();;
		produtoDao = new ProdutoDao(em);
	}
	
	public void cadastrar(Produto produto) {
		em.getTransaction().begin();
		this.produtoDao.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizaClientes(Produto produto) {
		em.getTransaction().begin();
		this.produtoDao.atualizaClientes(produto);
		em.getTransaction().commit();
		em.close();
	}
}
