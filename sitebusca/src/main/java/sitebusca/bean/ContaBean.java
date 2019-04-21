package sitebusca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="contaBean")
@SessionScoped

public class ContaBean {	
	
	
public String getRedirectConta() {	
    	return "contaView?faces-redirect=true";       
    }



public String getRedirectFavorito() {	
    	return "favoritosView?faces-redirect=true";       
    }

public String getRedirectHome() {
		
	return "homeView?faces-redirect=true";
   
}
	

}
