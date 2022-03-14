package correios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "produtos")
public class Produto {
	
	@Id @GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nomeProduto;
	private String descricao;
	private Float valorProduto;


	public Produto() {
	}
	
	public Produto(String NomeDoProduto, String Descricao, Float ValorProduto) {
		this.nomeProduto = NomeDoProduto;
		this.descricao = Descricao;
		this.valorProduto = ValorProduto;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Float valorProduto) {
		this.valorProduto = valorProduto;
	}
}
