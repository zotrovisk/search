package sitebusca.entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "subcategoria", schema = "searchti")
public class SubCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codSubCategoria")
	private long codSubCategoria;
	
	@Size(min = 3, max = 83)
	@Column(nullable = false)
	private String nomeSubCategoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codCategoria_fk")
	private Categoria categoria;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subCategoria") 
	private List<Produto> produtos;
	
	
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public SubCategoria(String nome_subCategoria) {

		this.nomeSubCategoria = nome_subCategoria;
		
	}
	
	public SubCategoria() {}

	public long getCodSubCategoria() {
		return codSubCategoria;
	}

	public void setCodSubCategoria(long codSubCategoria) {
		this.codSubCategoria = codSubCategoria;
	}

	public String getNomeSubCategoria() {
		return nomeSubCategoria;
	}

	public void setNomeSubCategoria(String nomeSubCategoria) {
		this.nomeSubCategoria = nomeSubCategoria;
	}

	public Categoria getCodCategoria() {
		return categoria;
	}

	public void setCodCategoria(Categoria codCategoria) {
		this.categoria = codCategoria;
	}
	
	
	
	
	
	
}
