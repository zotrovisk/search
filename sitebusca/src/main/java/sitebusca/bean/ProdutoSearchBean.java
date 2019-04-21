package sitebusca.bean;

import java.io.IOException;
import java.net.SocketTimeoutException;
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

@ManagedBean(name ="getProdSearch")
@SessionScoped

public class ProdutoSearchBean {
	
	    public List<Produto> produtosFiltrados;
	    public List<Produto> produtos;
	    public List<SubCategoria> subCategorias;
	    private List<Produto> produtoSearch;	
	    private Produto produtoInfo = new Produto();


	    @PostConstruct
	    public void init() {
			produtosFiltrados = new ArrayList<Produto>();
			produtoSearch = new ArrayList<Produto>();
			subCategorias = new ArrayList<SubCategoria>();

	    	produtos = ProdutosBean.buscarProdutos();
	    	subCategorias = ProdutosBean.subCategorias(); 
	    	System.out.println("InitPRodSearch......");
	    }
	
	    	
	    
	
	public void filtrarProdutosString() {
		
		boolean valida = true;
		Produto prodRetorno = new Produto();
		char caracter;
		boolean teste = false;
		char letra2;
		char[] vetorLetrasPalavraChaveBD = new char[3];
		char[] vetorletrasPalavraChave= new char[3];
		char[] letrasPalavraChave;
		int contProd = 0;
	

		Produto prodSearch = produtoSearch.get(0);
		
		String palavraChave = prodSearch.getNomeProd().toLowerCase();
	
		letrasPalavraChave = palavraChave.toCharArray();
		/*Buscas por produtos ou subcategorias com 3 caracteres*/		
		if(letrasPalavraChave.length == 3) {
			
			for(int i2 = 0 ; i2 < letrasPalavraChave.length;i2++) {
				

				if(i2 < 3) {
					 caracter = letrasPalavraChave[i2];
					 					 
					 vetorletrasPalavraChave[i2] = caracter;
				}
			   
			    
		}
		
		
		for(int i = 0 ; i < produtos.size();i++) {
			
			  prodRetorno = produtos.get(i);
			  
			  
			  String Nomeprod = prodRetorno.getNomeProd().toLowerCase();
			  char [] letrasNomeProd = Nomeprod.toCharArray();
			  
			  for(int i3 = 0 ; i3 < letrasNomeProd.length;i3++) {
					
					if(i3 < 3) {
						 	letra2 = letrasNomeProd[i3];
						 	vetorLetrasPalavraChaveBD[i3] = letra2;
					}
				   
				    
			}
			  
			  for(int i4 = 0; i4 < vetorLetrasPalavraChaveBD.length;i4++) {
				  		String let1	=  String.valueOf(vetorLetrasPalavraChaveBD[i4]);
				  		String let2	= String.valueOf(vetorletrasPalavraChave[i4]);
				  		
				  		if(let1.equals(let2)) {
				  			valida = true;
				  			
				  		}else {
				  			valida = false;
				  			break;

				  		}
				  
			  }
			  
			  
			  
			  
			  
			  
			  if(valida) {
					produtosFiltrados.add(prodRetorno);
				}else {
					 produtosFiltrados.clear();
					List<Produto> listaProduto	= filtraProdutosSubCat(palavraChave);
					
					if(listaProduto.size() > 0){
						
						for(int i6 = 0 ; i6 < listaProduto.size();i6++) {
							Produto pr = listaProduto.get(i6);
							
							 
							 if(!produtosFiltrados.contains(pr)) {
								produtosFiltrados.add(listaProduto.get(i6)) ;
								 
							 }
							 
							 
						}
						
					}
					
				}
			  
			 
			  
		}
		
				
		}
		
		
		if(letrasPalavraChave.length > 3 && letrasPalavraChave.length <= 83) {
			
			  List<Character> arrayCaracteresPalavraChave = new ArrayList<Character>();
			  
			
			
			   for(int i7 = 0 ; i7 < palavraChave.length();i7++) {

				   		if(palavraChave.charAt(i7) != ' ') {
				   			arrayCaracteresPalavraChave.add(palavraChave.charAt(i7));

				   		}else {
			  			}

					 
		}
			   
			
			  
			   while(contProd < produtos.size()) {
			
					   prodRetorno = produtos.get(contProd);
						  

						  
						  
						  String Nomeprod = prodRetorno.getNomeProd().toLowerCase().trim();
						  List<Character> arrayCaracteresBD = new ArrayList<Character>();
						  
						  for(int i9 = 0 ; i9 < Nomeprod.length();i9++) {
										
							  			if(Nomeprod.charAt(i9) != ' ') {
											arrayCaracteresBD.add(Nomeprod.charAt(i9));
							  			}
							    
						}
						  
						  
			
						
						  for(int i10 = 0; i10 < arrayCaracteresPalavraChave.size();i10++) {
							  /*Batimento com 100% de acerto removendo-se espaços em branco*/
							  		 
							  		
							  	char let2	= arrayCaracteresPalavraChave.get(i10);
							  	
							  								  	
							  		/*Deduzindo-se sempre que para comparação a quantidade de caracteres que o usuário pode inserir é igual a qtd de caracteres do produto no BD!*/
							  		if(arrayCaracteresPalavraChave.size() == arrayCaracteresBD.size()) {
							  			
									  	char let1 =  arrayCaracteresBD.get(i10);

							  			if(let1 == let2) {
											 
								  			 valida = true;
								  			}
								  			 else {
								  			valida = false;
								  			break;
								  		}
							  			
							  		}else {
							  			valida = false;
							  			break;
							  			
							  		}
							  		
							  		
						  }
						  
						  
						  
						  
						  if(valida) {
							  teste = true;
								produtosFiltrados.add(prodRetorno);
							}else {
								if(!teste) {
									 produtosFiltrados.clear();

								}
								 
								List<Produto> listaProduto	= filtraProdutosSubCat2(palavraChave);
								
								if(listaProduto.size() > 0){
									
									for(int i6 = 0 ; i6 < listaProduto.size();i6++) {
										Produto pr = listaProduto.get(i6);
										
										 
										 if(!produtosFiltrados.contains(pr)) {
											produtosFiltrados.add(listaProduto.get(i6)) ;
											 
										 }
										 
										 
									}
									
								}
								
							}
				  	
					  	  
				  	
				   contProd++;
			   }
	
		}
		
		
		
		
}
	


    
public  List<Produto> filtraProdutosSubCat2(String palavraChave) {
	
	boolean valida2 = false;
	String produtoInfor = palavraChave;
	char letra1;
	char letra2;
	char[] vetorSubCat;
	char[] vetorletrasNomeProd;
	List<Produto> listaProdutos = new ArrayList<Produto>();
	int sizevetorLetrasPalavraChaveBD = 0;
	int sizevetorletrasPalavraChave = 0;
	int vetorSelecionado = 0;
	
	char[] letrasPalavraChave =	produtoInfor.toCharArray();
	
	vetorletrasNomeProd = new char[letrasPalavraChave.length];
	
	
	for(int i2 = 0 ; i2 < letrasPalavraChave.length;i2++) {
		
		
			 letra1 = letrasPalavraChave[i2];
			 vetorletrasNomeProd[i2] = letra1;
		

	    
}
	
	
	for(int i2 = 0 ; i2 < subCategorias.size();i2++){
		   Produto podutoFiltrado = new Produto();
		   SubCategoria subCategoria2 = subCategorias.get(i2);
		   
		   char[] subCat  = subCategoria2.getNomeSubCategoria().toLowerCase().toCharArray();
		   
		   vetorSubCat = new char[subCat.length];
		   
		   for(int i4 = 0 ; i4 < subCat.length;i4++) {
				
				
				
					 letra2 = subCat[i4];
					 vetorSubCat[i4] = letra2;
				
	
			    
		}
		   
		   
		   sizevetorLetrasPalavraChaveBD = vetorSubCat.length;
	  		 sizevetorletrasPalavraChave = vetorletrasNomeProd.length;

	  		 if(sizevetorLetrasPalavraChaveBD >= sizevetorletrasPalavraChave) {
	  			 
	  			vetorSelecionado = sizevetorletrasPalavraChave;
	  		 
	  		 }else if(sizevetorLetrasPalavraChaveBD <= sizevetorletrasPalavraChave) {
	  			 
		  			vetorSelecionado = sizevetorLetrasPalavraChaveBD;

	  		 }
		  
		/*Deduzindo-se sempre que a quantidade de caracteres que o usuário pode inserir é maior que a qtd de caracteres do produto no BD!*/
		  for(int i10 = 0; i10 < vetorSelecionado;i10++) {
			  /*Batimento com 100% de acerto removendo-se espaços em branco*/
			  		 
			  		String let1	=  String.valueOf(vetorSubCat[i10]);
			  		String let2	= String.valueOf(vetorletrasNomeProd[i10]);

			  		if(let1.equals(let2)) {
			  			valida2 = true;
			  			
			  		}else {
			  			valida2 = false;

			  		}
			  
		  }
		  
		  
		  
		  
		
		   
		   
		   
		   		if(valida2) {

		   		  for(int i11 = 0 ; i11 < produtos.size(); i11++) {
			    	   Produto produto = produtos.get(i11);
			
			    	   String subCategoria = produto.getSubCategoria().getNomeSubCategoria().toLowerCase();
			    	   
			    	   if(subCategoria.equals(produtoInfor) ) {
			    		   
					
					       podutoFiltrado = produto;
					       listaProdutos.add(podutoFiltrado);
			    	   }			    	   
		    	   }

		    	   
		   		}
	   
   
	   }

	
	
	 return listaProdutos;
	
}

	  

	public  List<Produto> filtraProdutosSubCat(String palavraChave) {
		
		boolean valida2 = false;
		String produtoInfor = palavraChave;
		char letra1;
		char letra2;
		char[] vetorSubCat = new char[3];
		char[] vetorletrasNomeProd = new char[palavraChave.length()];
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		char[] letrasPalavraChave =	produtoInfor.toCharArray();
		
			for(int i22 = 0 ; i22 < letrasPalavraChave.length;i22++) {
				
				
				if(i22 < 3) {
					 letra1 = letrasPalavraChave[i22];
					 vetorletrasNomeProd[i22] = letra1;
				}
	
			    
		}
		
		
		
		for(int i2 = 0 ; i2 < subCategorias.size();i2++){
			   Produto podutoFiltrado = new Produto();
			   SubCategoria subCategoria2 = subCategorias.get(i2);
			   
			   
			   char[] subCat  = subCategoria2.getNomeSubCategoria().toLowerCase().toCharArray();
			   
			   
			   for(int i4 = 0 ; i4 < subCat.length;i4++) {
					
					
					if(i4 < 3) {
						 letra2 = subCat[i4];
						 vetorSubCat[i4] = letra2;
					}
		
				    
			}
			   
			   for(int i44 = 0; i44 < vetorSubCat.length;i44++) {
			  		String let1	=  String.valueOf(vetorSubCat[i44]);
			  		String let2	= String.valueOf(vetorletrasNomeProd[i44]);
			 

			  		if(let1.equals(let2)) {
			  			valida2 = true;
			  			
			  		}else {
			  			valida2 = false;
			  			break;

			  		}
			  
		  }
			   
			   
			   
			   		if(valida2) {

			   		  for(int i33 = 0 ; i33 < produtos.size(); i33++) {
				    	   Produto produto = produtos.get(i33);
						
				    	   if(produto.getSubCategoria().getNomeSubCategoria().equals(subCategoria2.getNomeSubCategoria() )) {
						       podutoFiltrado = produto;
						       listaProdutos.add(podutoFiltrado);
				    	   }			    	   
			    	   }

			    	   
			   		}
		   
       
		   }
	
		
		
		 return listaProdutos;
		
	}
	

	public Produto getProduto() {
		return this.produtoInfo;
	}
	
	public  List<Produto> getProdutosFiltrados() {
		return this.produtosFiltrados;
	}

	public List<Produto> getProdutosSearch() {
		return produtoSearch;
	}
	
public void teste4() {
	System.out.println("Teste4");
}

public void getTeste5() {
	System.out.println("Teste5");
}

	public void filtrar(ActionEvent actionEven) {
		try {
			String produtoFiltrado2 = null;		
			produtosFiltrados.clear();
			produtoSearch.clear();
				if(produtoInfo.getNomeProd()==null || produtoInfo.getNomeProd().trim().equals("")){
					FacesContext.getCurrentInstance().getExternalContext().redirect("error404View.xhtml");
		
				}else{
					produtoSearch.add(produtoInfo);
					produtoFiltrado2 = produtoInfo.getNomeProd();
					
					produtoInfo = new Produto();

			    	filtrarProdutosString();
			    	boolean result =filtraPreco(produtoFiltrado2);
    	
					if( (this.produtosFiltrados.size() > 0 && produtoFiltrado2.length() >= 3) || result == true) {
						FacesContext.getCurrentInstance().getExternalContext().redirect("searchView.xhtml");

					}else {
						FacesContext.getCurrentInstance().getExternalContext().redirect("error404View.xhtml");						
					}
				}
				
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public boolean  filtraPreco(String preco) {
		boolean isNumber = false;
		List<Produto> listaProd = ProdutosBean.produtosByPreco(preco);
		if(listaProd.size() > 0) {
			isNumber = true;
			
			for(int i = 0 ; i < listaProd.size();i++) {
				produtosFiltrados.add(listaProd.get(i));
			}
			
		}
		
		return isNumber;
		
	}

	public void filtrar3(String param) {

		try {
			this.produtosFiltrados = MenuViewBean.filtraSubCategoria(param);
			
			if(this.produtosFiltrados.size() > 0) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("subCategoriaView.xhtml");
			}else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("error404View.xhtml");
			}
			
		} catch (Exception e) {
			
			System.out.println("exception: "+e.getMessage());
			
		}
	
	}
	



	
	
}





