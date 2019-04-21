package sitebusca.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "SiteProduto")
@Table(name = "produtoSite", schema = "searchti")
public class SiteProduto implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private SiteProdutoId id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("siteId")
    private Site sites;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("produtoId")
    private Produto produtos;
 
    @Column(name = "precoProd")
    private String precoProduto;
 
    public SiteProduto() {}
 
    public SiteProduto(Site site, Produto produto,String precoProd) {
        this.sites = site;
        this.produtos = produto;
        this.precoProduto = precoProd;
        this.id = new SiteProdutoId(site.getCodSite(), produto.getCodProd());
    }
 
    public SiteProdutoId getId() {
		return id;
	}

	public void setId(SiteProdutoId id) {
		this.id = id;
	}

	public Site getSite() {
		return sites;
	}

	public void setSite(Site site) {
		this.sites = site;
	}

	public Produto getProduto() {
		return produtos;
	}

	public void setProduto(Produto produto) {
		this.produtos = produto;
	}

	public String getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}


 
  
	@Embeddable
    public static class SiteProdutoId
        implements Serializable {
     
    	private static final long serialVersionUID = 1L;

    	@Column(name = "produtos_codProd")
        private long siteId;
     
        @Column(name = "sites_codSite")
        private long produtoId;
     
        public SiteProdutoId() {}
     
        public SiteProdutoId(
            long siteId, 
            long produtoId) {
            this.siteId = siteId;
            this.produtoId = produtoId;
        }

		public long getSiteId() {
			return siteId;
		}

		public void setSiteId(long siteId) {
			this.siteId = siteId;
		}

		public long getProdutoId() {
			return produtoId;
		}

		public void setProdutoId(long produtoId) {
			this.produtoId = produtoId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (produtoId ^ (produtoId >>> 32));
			result = prime * result + (int) (siteId ^ (siteId >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SiteProdutoId other = (SiteProdutoId) obj;
			if (produtoId != other.produtoId)
				return false;
			if (siteId != other.siteId)
				return false;
			return true;
		}
     
  
    
}
	
	
}