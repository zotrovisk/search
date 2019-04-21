package sitebusca.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "especificacaotecnica", schema = "searchti")
public class EspecificacaoTecnica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codEspecificacao;
	
	@Size(min = 10, max = 500)
	@Column(nullable = false)
	private String especificacaoTecnica;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produtoespec_fk")
	private Produto prodespec;
	
	public EspecificacaoTecnica(String especificacao_tecnica) {
		this.especificacaoTecnica = especificacao_tecnica;
	}
	
	public EspecificacaoTecnica() {}


	public long getCodEspecificacao() {
		return codEspecificacao;
	}



	public void setCodEspecificacao(long codEspecificacao) {
		this.codEspecificacao = codEspecificacao;
	}



	public String getNomeEspecificacaoTecnica() {
		return especificacaoTecnica;
	}



	public void setEspecificacaoTecnica(String especificacaoTecnica) {
		this.especificacaoTecnica = especificacaoTecnica;
	}

	public Produto getProdutos() {
		return prodespec;
	}

	public void setProdutos(Produto produtos) {
		this.prodespec = produtos;
	}

	
}
