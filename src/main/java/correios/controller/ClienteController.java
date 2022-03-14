package correios.controller;

import javax.persistence.EntityManager;

import correios.dao.ClienteDao;
import correios.model.Cliente;
import correios.util.JPAUtil;


public class ClienteController {
	
	private ClienteDao clienteDao;
	private EntityManager em;
	
	public ClienteController() {
		this.em = JPAUtil.getEntityManager();;
		clienteDao = new ClienteDao(em);
	}
	
	public void cadastrar(Cliente cliente) {
		em.getTransaction().begin();
		this.clienteDao.cadastrar(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar( Cliente cliente) {
		em.getTransaction().begin();
		this.clienteDao.atualizar(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public Cliente clienteValido(String login, String senha) {
		return this.clienteDao.clienteValido(login, senha);
	}

}
