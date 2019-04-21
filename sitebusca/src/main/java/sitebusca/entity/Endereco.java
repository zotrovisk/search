package sitebusca.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Endereco {

@SerializedName("cep")
@Expose
private String cep;
@SerializedName("logradouro")
@Expose
private String logradouro;
@SerializedName("complemento")
@Expose
private String complemento;
@SerializedName("bairro")
@Expose
private String bairro;
@SerializedName("localidade")
@Expose
private String localidade;
@SerializedName("uf")
@Expose
private String uf;
@SerializedName("unidade")
@Expose
private String unidade;
@SerializedName("ibge")
@Expose
private String ibge;
@SerializedName("gia")
@Expose
private String gia;

public String getCep() {
return cep;
}

public void setCep(String cep) {
this.cep = cep;
}

public String getLogradouro() {
return logradouro;
}

public void setLogradouro(String logradouro) {
this.logradouro = logradouro;
}

public String getComplemento() {
return complemento;
}

public void setComplemento(String complemento) {
this.complemento = complemento;
}

public String getBairro() {
return bairro;
}

public void setBairro(String bairro) {
this.bairro = bairro;
}

public String getLocalidade() {
return localidade;
}

public void setLocalidade(String localidade) {
this.localidade = localidade;
}

public String getUf() {
return uf;
}

public void setUf(String uf) {
this.uf = uf;
}

public String getUnidade() {
return unidade;
}

public void setUnidade(String unidade) {
this.unidade = unidade;
}

public String getIbge() {
return ibge;
}

public void setIbge(String ibge) {
this.ibge = ibge;
}

public String getGia() {
return gia;
}

public void setGia(String gia) {
this.gia = gia;
}




@Override
public String toString() {
	return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro
			+ ", localidade=" + localidade + ", uf=" + uf + ", unidade=" + unidade + ", ibge=" + ibge + ", gia=" + gia
			+ "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
	result = prime * result + ((cep == null) ? 0 : cep.hashCode());
	result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
	result = prime * result + ((gia == null) ? 0 : gia.hashCode());
	result = prime * result + ((ibge == null) ? 0 : ibge.hashCode());
	result = prime * result + ((localidade == null) ? 0 : localidade.hashCode());
	result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
	result = prime * result + ((uf == null) ? 0 : uf.hashCode());
	result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
	Endereco other = (Endereco) obj;
	if (bairro == null) {
		if (other.bairro != null)
			return false;
	} else if (!bairro.equals(other.bairro))
		return false;
	if (cep == null) {
		if (other.cep != null)
			return false;
	} else if (!cep.equals(other.cep))
		return false;
	if (complemento == null) {
		if (other.complemento != null)
			return false;
	} else if (!complemento.equals(other.complemento))
		return false;
	if (gia == null) {
		if (other.gia != null)
			return false;
	} else if (!gia.equals(other.gia))
		return false;
	if (ibge == null) {
		if (other.ibge != null)
			return false;
	} else if (!ibge.equals(other.ibge))
		return false;
	if (localidade == null) {
		if (other.localidade != null)
			return false;
	} else if (!localidade.equals(other.localidade))
		return false;
	if (logradouro == null) {
		if (other.logradouro != null)
			return false;
	} else if (!logradouro.equals(other.logradouro))
		return false;
	if (uf == null) {
		if (other.uf != null)
			return false;
	} else if (!uf.equals(other.uf))
		return false;
	if (unidade == null) {
		if (other.unidade != null)
			return false;
	} else if (!unidade.equals(other.unidade))
		return false;
	return true;
}



}