package correios.dao;

import javax.persistence.EntityManager;

import correios.model.Cliente;


public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}

	public Cliente clienteValido(String login, String senha) {
		try{
			String jpql = "FROM Cliente WHERE nome = :login AND senha = :senha";
			return em.createQuery(jpql, Cliente.class).setParameter("login", login).setParameter("senha", senha).getSingleResult();
		} catch (Exception e) {
			System.err.println("Usuário não encontrado!");
			return null;
		}
	}
}
