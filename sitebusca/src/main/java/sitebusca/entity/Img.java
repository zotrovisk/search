package sitebusca.entity;

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
@Table(name = "imgData", schema = "searchti")
public class Img {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codImgUrl",nullable = false)
	private long codImgUrl;	
	
	@Column(name = "urlImg",nullable = false)
	private String urlImg;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_fk")
	private Produto prodimg;
	
		
	
	public Img() {}

	public Img(String urlImg) {
		this.urlImg = urlImg;
	}
	
	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public long getCodImgUrl() {
		return codImgUrl;
	}

	public void setCodImgUrl(long codImgUrl) {
		this.codImgUrl = codImgUrl;
	}

	public Produto getProdimg() {
		return prodimg;
	}

	public void setProdimg(Produto prodimg) {
		this.prodimg = prodimg;
	}


	
	
}
