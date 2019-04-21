package sitebusca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "searchti")
public class Usuario {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long codUsu;
	
	
	@Column(nullable = false)
	private String emailUsu;
	
	@Column(nullable = false)
	private String nomeUsu;

	@Column(nullable = false)
	private String senhaUsu;
	
	public Usuario() {}

	public long getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(long codUsu) {
		this.codUsu = codUsu;
	}

	public String getNomeUsu() {
		return nomeUsu;
	}

	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	

	public String getEmailUsu() {
		return emailUsu;
	}

	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}

	public String getSenhaUsu() {
		return senhaUsu;
	}

	public void setSenhaUsu(String senhaUsu) {
		this.senhaUsu = senhaUsu;
	}
	
}
