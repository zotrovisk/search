package sitebusca.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import sitebusca.entity.Produto;
import sitebusca.entity.SubCategoria;
import sitebusca.entity.Usuario;

@ManagedBean(name ="getValidationBean")
@SessionScoped

public class LoginValidationBean {
	
	    public List<Produto> produtosFiltrados;
	    public List<Produto> produtos;
	    public List<SubCategoria> subCategorias;
	    private List<Produto> produtoSearch;	
	    private Produto produtoInfo = new Produto();
	    private Usuario loginValBean= new Usuario();
	    private Usuario usuSelect;
	    private static boolean inOff;
	    private boolean validaBoolean;
	    public boolean validaUsu;


	    @PostConstruct
	    public void init() {
			produtosFiltrados = new ArrayList<Produto>();
			produtoSearch = new ArrayList<Produto>();
			subCategorias = new ArrayList<SubCategoria>();

	    	produtos = ProdutosBean.buscarProdutos();
	    	subCategorias = ProdutosBean.subCategorias(); 
	    	
	    	Usuario usuario = new Usuario();
	    	
	    	System.out.println("Init-LoginValidationBean");
	    	
	    }
	
		public void valida(ActionEvent actionEven) {
			
			System.out.println("teste bean");
			System.out.println("getNomeUsu: "+loginValBean.getNomeUsu());
			System.out.println("getSenhaUsu: "+loginValBean.getSenhaUsu());
			Usuario UsuInput = getUsuario();
			setValidaUsu(false);
			
			
			String nomeUsuario = UsuInput.getNomeUsu();
			
			List<Usuario> listaUsu =  UsuarioBean.buscarUsuarios();
			
			 for(int i = 0 ; i < listaUsu.size();i++) {
				 
				 Usuario usu = listaUsu.get(i);
				 String nomeUsu = usu.getNomeUsu();
				 
				 if(nomeUsu.equals(nomeUsuario)) {
					 System.out.println("equals");
					 setValidaUsu(true);
				 }
				 
				 
			 }
			 
			 if(getValidaUsu()) {
					try {
						System.out.println("redirectConta");
						
						FacesContext.getCurrentInstance().getExternalContext().redirect("contaView.xhtml");
					} catch (IOException e) {
						
						e.printStackTrace();
						
					}

			 }
			 
			 
		}
		
		public void setValidaUsu(boolean validaUsu) {
				this.validaUsu = validaUsu;
		}
		
		public boolean getValidaUsu() {
			return this.validaUsu;
		}
		
		
		public void valida2(ActionEvent actionEven) {
			System.out.println("Teste here...");
		}
		
		public void logar2(String param1) {
				
				System.out.println("teste4");

				System.out.println(param1);
			
		}
		
		public Usuario getUsuario() {
			
				System.out.println("teste getUsuario");
			
				System.out.println("Nome do usuário: "+loginValBean.getNomeUsu());
				System.out.println("Senha do usuário: "+loginValBean.getSenhaUsu());
						
				
				
				validaUsu(loginValBean);
			
			
			return this.loginValBean;
		
		}
		
		
		public void validaUsu(Usuario usuario) {
			
		 validaBoolean = true;
		
		System.out.println("validaUsua in");	
			
		String nomeUsu = usuario.getNomeUsu();
		
		String senhaUsu = usuario.getSenhaUsu();
		
		try {
				
					System.out.println("inValidaUsuario");
					List<Usuario> usuBack = UsuarioBean.buscarUsuarios();
					System.out.println("usuBack:");
					
					for(int i = 0 ; i < usuBack.size();i++) {
						                                                                             
					Usuario usu	= usuBack.get(i);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
					System.out.println("nome: "+usu.getNomeUsu());
					
					if(nomeUsu.equals(usu.getNomeUsu())) {
						
						setUsuario(usu);
						validation(true);
						
					}else {
						
						validation(false);
							
					}
					System.out.println("senha: "+usu.getSenhaUsu());
					}
					
				System.out.println("NomeUsu: "+getUsu().getNomeUsu());
				
				
			 
			
		} catch (Exception e) {
				System.out.println("Menssage Error: "+e.getMessage());
		}
		
			
		}
		
		public  Usuario getUsu() {
			return this.usuSelect;
		}
	    
	public void setUsuario(Usuario usu) {
		this.usuSelect = usu;
	}
	
	public void redirectConta() {
		System.out.println("redirectConta: "+validaBoolean);
		
		if(validaBoolean) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("contaView.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean validation(boolean validation) {
		
		return this.inOff = validation;
	}
	
	public void redirectValidationLogin() {
		
try {
		
	FacesContext.getCurrentInstance().getExternalContext().redirect("contaView.xhtml");

	
} catch (Exception e) {
		System.out.println("e: "+e.getMessage());
}
		
	}

}





