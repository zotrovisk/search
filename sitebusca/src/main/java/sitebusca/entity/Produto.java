package sitebusca.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "produto", schema = "searchti")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codProd;
	
	@Column(nullable = false)
	private String nomeProd;

	@Column(nullable = false)
	private String nomeCat;
	
	@Size(min = 1, max = 200 ) 
	@Column(nullable = false)
	private String descricaoProd;
	
	@Column(nullable = false)
	private long contFavorito;
	
	@Column(nullable = false, columnDefinition = "BIT(1) default 0")
	private boolean produtoDestaque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoria_fk")
	private SubCategoria subCategoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prodimg") 
	private List<Img> imagens;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prodespec") 
	private List<EspecificacaoTecnica> espectecnicas;
	
	
    @OneToMany(
        mappedBy = "produtos",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SiteProduto> sites = new ArrayList<>();
	
	
	public Produto(String nomeProd,String descricaoProd) {
		this.nomeProd = nomeProd;
		this.descricaoProd = descricaoProd;
	}
	
	public Produto() {}
	
		
	
	public boolean isProdutoDestaque() {
		return produtoDestaque;
	}

	public void setProdutoDestaque(boolean produtoDestaque) {
		this.produtoDestaque = produtoDestaque;
	}

	public List<SiteProduto> getSites() {
		return sites;
	}

	public void setSites(List<SiteProduto> sites) {
		this.sites = sites;
	}


	public long getContFavorito() {
		return contFavorito;
	}

	public void setContFavorito(long contFavorito) {
		this.contFavorito = contFavorito;
	}


	public SubCategoria getSubCategoria() {
		return subCategoria;
	}


	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}



	public long getCodProd() {
		return codProd;
	}

	public void setCodProd(long codProd) {
		this.codProd = codProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}


	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}


	public String getDescricaoProd() {
		return descricaoProd;
	}


	public void setDescricaoProd(String descricaoProd) {
		this.descricaoProd = descricaoProd;
	}


	public List<EspecificacaoTecnica> getEspectecnicas() {
		return espectecnicas;
	}

	public void setEspectecnicas(List<EspecificacaoTecnica> espectecnicas) {
		this.espectecnicas = espectecnicas;
	}

	public String getNomeCat() {
		return nomeCat;
	}

	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}

	public List<Img> getImagens() {
		return imagens;
	}

	public void setImagens(List<Img> imagens) {
		this.imagens = imagens;
	}


	

}
