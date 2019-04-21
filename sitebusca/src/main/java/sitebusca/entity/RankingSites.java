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

@Entity
@Table(name = "rankingSites", schema = "searchti")
public class RankingSites implements  Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codColocacao;
	
	@Column(nullable = false)
	private int colocacaoSite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_fk")	
	private Site site;
	
	public RankingSites() {}
	
	public RankingSites(int colocacaoSite) {
		this.colocacaoSite = colocacaoSite;
		
	}

	public long getCodColocacao() {
		return codColocacao;
	}

	public void setCodColocacao(long codColocacao) {
		this.codColocacao = codColocacao;
	}

	public int getColocacaoSite() {
		return colocacaoSite;
	}

	public void setColocacaoSite(int colocacaoSite) {
		this.colocacaoSite = colocacaoSite;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	
	
	
	
	
}
