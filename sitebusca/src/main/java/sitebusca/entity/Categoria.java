package sitebusca.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name = "categoria", schema = "searchti")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codCategoria;
	
	@Size(min = 3, max = 83)
	@Column(nullable = false)
	private String nomeCategoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria") 
	private List<SubCategoria> subCategorias;
	
	
	public Categoria(String nome_categoria) {
		this.nomeCategoria = nome_categoria;
		
	}
	
	public Categoria() {}


	public long getCodCategoria() {
		return codCategoria;
	}


	public void setCodCategoria(long codCategoria) {
		this.codCategoria = codCategoria;
	}


	public String getNomeCategoria() {
		return nomeCategoria;
	}


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}


	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
	}
	

	
	
	
	
	
}
