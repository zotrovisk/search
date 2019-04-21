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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "site", schema = "searchti")
public class Site implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codSite;
	
	@Size(min = 10, max = 100)
	@Column(nullable = false)
	private String urlSite;
	
	@Size(min = 1, max = 100)
	@Column(nullable = false)
	private String nomeSite;
	
	
	
    @OneToMany(
            mappedBy = "sites", 
            		cascade = CascadeType.ALL, 
            orphanRemoval = true
        )
        private List<SiteProduto> produtos = new ArrayList<>();
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "site") 
	private List<RankingSites> rankings;
	
	public Site(String url_site,String nome_site) {
		this.urlSite = url_site;
		this.nomeSite = nome_site;
	}
	
	
	public Site() {}


	public long getCodSite() {
		return codSite;
	}


	public void setCodSite(long codSite) {
		this.codSite = codSite;
	}


	public String getUrlSite() {
		return urlSite;
	}


	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}


	public String getNomeSite() {
		return nomeSite;
	}


	public void setNomeSite(String nomeSite) {
		this.nomeSite = nomeSite;
	}


	public List<SiteProduto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<SiteProduto> produtos) {
		this.produtos = produtos;
	}


	public List<RankingSites> getRankings() {
		return rankings;
	}


	public void setRankings(List<RankingSites> rankings) {
		this.rankings = rankings;
	}
	

		
	
}

