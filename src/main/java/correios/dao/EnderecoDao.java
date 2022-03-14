package correios.dao;

import javax.persistence.EntityManager;

import correios.model.Endereco;

public class EnderecoDao {
	
	private EntityManager em;

	public EnderecoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Endereco endereco) {
		this.em.persist(endereco);
	}

	public Endereco buscaCEP(String CEP) {
		try{
			String jpql = "FROM Endereco WHERE CEP = :CEP";
			return em.createQuery(jpql, Endereco.class).setParameter("CEP", CEP).getSingleResult();
		} catch (Exception e) {
			System.err.println("CEP não encontrado!");
			return null;
		}
	}
}
