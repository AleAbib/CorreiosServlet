package correios.controller;

import javax.persistence.EntityManager;

import correios.dao.EnderecoDao;
import correios.model.Endereco;
import correios.util.JPAUtil;

public class EnderecoController {
	
	private EnderecoDao enderecoDao;
	private EntityManager em;
	
	public EnderecoController() {
		this.em = JPAUtil.getEntityManager();;
		enderecoDao = new EnderecoDao(em);
	}
	
	public void cadastrar(Endereco endereco) {
		em.getTransaction().begin();
		this.enderecoDao.cadastrar(endereco);
		em.getTransaction().commit();
		em.close();
	}

	public Endereco buscaCEP(String CEP) {
		return this.enderecoDao.buscaCEP(CEP);
	}
}
