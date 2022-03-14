package correios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "clientes")
public class Cliente {
	
	@Id @GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	@ManyToOne
	private Endereco endereco;
	@ManyToOne
	private Produto produto;
	private Float valorFrete;
	private int prazoEntrega;
	
	public Cliente() {
		
	}

	public Cliente(String nomeCliente, String senhaCliente, Endereco endereco) {
		this.nome = nomeCliente;
		this.senha = senhaCliente;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Float getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Float valorFrete) {
		this.valorFrete = valorFrete;
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
