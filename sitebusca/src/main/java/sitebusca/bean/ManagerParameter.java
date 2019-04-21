package sitebusca.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSeparator;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import sitebusca.entity.Img;
import sitebusca.entity.Produto;
import sitebusca.entity.RankingSites;
import sitebusca.entity.Site;
import sitebusca.entity.SubCategoria;

@ManagedBean(name="prodDesc")
@RequestScoped
public class ManagerParameter{

	

	public static String nome;
	public String codProd;
	public String subCat;
	public static String codProd2;
	public static String especTec;
	private MenuModel menuDesc = new DefaultMenuModel();
	private static List<SubCategoria> subCategorias;
	private static List<Produto> produtos;
	DefaultSubMenu produtosDesc;
	DefaultMenuItem produtoSubCategoria2;
	private String url;
	   
	static Map<String,Site> rankingSite = new HashMap<String,Site>();


	@PostConstruct
	public void paransValue(){
    
		
	nome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nome");
	this.codProd = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codProd");
	this.subCat = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("subCategoria");
	codProd2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codProd");
	especTec = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("especTec");
	
	menuDesc = createMenuDescricaoProd();
	subCategorias = new ArrayList<SubCategoria>();
	produtos = new ArrayList<Produto>();
	
	}

	public Site ranking(String keycolocacao) {
		if(rankingSite.containsKey(keycolocacao)) {
			
			
			return rankingSite.get(keycolocacao);
		}
		
		return null;
		
	}
	
	


	public String getNomePreco1Colocado() {
		
		//Varrer todos os sites do produto desejado e buscar pela colocação
				Produto prodByName = null ;
				Site site = null;
				String nomeSite = "";
				String precoProduto = "";
				boolean out = false;
				String resultConcat = "";
				String colocacao = "1";
				
				String nome_produto =  nome;
				if(nome_produto != null) {
					prodByName = ProdutosBean.buscarProdutoByName(nome_produto);
					
					
					List<Site> listaSites = ProdutosBean.getSitesByIdProd(prodByName.getCodProd());		
				
					for(int i = 0 ; i < listaSites.size();i++) {
						site  = listaSites.get(i);
						
						  
						  List<RankingSites> rankingSites = site.getRankings();
						  
						  for(int i2 = 0 ; i2 < rankingSites.size();i2++) {
							  String colocacao2= String.valueOf(rankingSites.get(i2).getColocacaoSite());

							  if(colocacao2.equals(colocacao)) {
								  				out = true;
								  				nomeSite = site.getNomeSite();
								  				precoProduto = ProdutosBean.getPrecoBySiteAndProdId(prodByName.getCodProd(), site.getCodSite());
								  				this.url = site.getUrlSite();
								 				break;
							  }
												  
								  
							  }
							if(out) {
								break;
							}
							
						  }
						  
					if(!nomeSite.equals(null) && !precoProduto.equals(null) ) {
						resultConcat = "Site com menor preço: "+nomeSite+" R$"+precoProduto;
					}
					
					}
				

				return resultConcat;
		
	}
	
	public String nomePreco(String colocacao) {
		
		//Varrer todos os sites do produto desejado e buscar pela colocação
				Produto prodByName = null ;
				Site site = null;
				String nomeSite = "";
				String precoProduto = "";
				boolean out = false;
				String resultConcat = "";
				
				String nome_produto =  nome;
				if(nome_produto != null) {
					prodByName = ProdutosBean.buscarProdutoByName(nome_produto);
					
					
					List<Site> listaSites = ProdutosBean.getSitesByIdProd(prodByName.getCodProd());		
				
					for(int i = 0 ; i < listaSites.size();i++) {
						site  = listaSites.get(i);
						
						  
						  List<RankingSites> rankingSites = site.getRankings();
						  
						  for(int i2 = 0 ; i2 < rankingSites.size();i2++) {
							  String colocacao2= String.valueOf(rankingSites.get(i2).getColocacaoSite());

							  if(colocacao2.equals(colocacao)) {
								  				out = true;
								  				nomeSite = site.getNomeSite();
								  				precoProduto = ProdutosBean.getPrecoBySiteAndProdId(prodByName.getCodProd(), site.getCodSite());

								 				break;
							  }
												  
								  
							  }
							if(out) {
								break;
							}
							
						  }
						  
					if(!nomeSite.equals(null) && !precoProduto.equals(null) ) {
						resultConcat = colocacao+"º "+nomeSite+" R$"+precoProduto;
					}
					
					}
				

				return resultConcat;
		
	}
	
	public String getUrlImgByProduto() {
		
		
		Produto prodByName = null ;
		Img img = null;
		String urlImg = "";
		
		String nome_produto = nome;
		
		if( nome_produto != null) {

		 urlImg = ProdutosBean.getImgByProd(nome_produto);		

		}
	

		return urlImg;
	}
	
	
	
	public String siteColocation(String colocacao) {
		
		
		//Varrer todos os sites do produto desejado e buscar pela colocação
		Produto prodByName = null ;
		Site site = null;
		String nomeSite = "";
		boolean out = false;
		
		String nome_produto =  nome;
		if(nome_produto != null) {
			prodByName = ProdutosBean.buscarProdutoByName(nome_produto);
			
			
		
			
		List<Site> listaSites = ProdutosBean.getSitesByIdProd(prodByName.getCodProd());		
			
			for(int i = 0 ; i < listaSites.size();i++) {
				site = listaSites.get(i);
				
				  
				  
				  List<RankingSites> rankingSites = site.getRankings();
				  
				  for(int i2 = 0 ; i2 < rankingSites.size();i2++) {
					  String colocacao2= String.valueOf(rankingSites.get(i2).getColocacaoSite());

					  if(colocacao2.equals(colocacao)) {
						  				out = true;
						  				nomeSite = site.getNomeSite();
						 				break;
					  }
										  
						  
					  }
					if(out) {
						break;
					}
					
				  }
				  
			}
	

		return nomeSite;
	}
	
	
	public MenuModel createMenuDescricaoProd(){
		String subCat =getsubCat();
		boolean out = false;
		int cont = 0 ;
		
		subCategorias = ProdutosBean.subCategorias();
		produtos = ProdutosBean.buscarProdutos();

		produtosDesc = new DefaultSubMenu(subCat);
		produtosDesc.setStyle("background-color:#5F7AD7");
		 
		for(int i2 = 0 ; i2 < subCategorias.size();i2++){
			   SubCategoria subCategoria2 = subCategorias.get(i2);
			   

			   
		       if(subCategoria2.getNomeSubCategoria().equals(subCat)) {
		    	   out = true;
		   
		    	   for(int i3 = 0 ; i3 < produtos.size(); i3++) {
			    	   Produto produto = produtos.get(i3);

			    	   
			    	   if(produto.getSubCategoria().getNomeSubCategoria().equals(subCat)) {
			    		   cont++;
			    		   if(cont <=15) {
			    			   
			    		   
			    		   
			    		   produtoSubCategoria2 = new DefaultMenuItem(produto.getNomeProd());
					       produtoSubCategoria2.setUrl("http://localhost:8080/sitebusca/descricaoView.xhtml?nome="+produto.getNomeProd()
					    			+ "&codProd="+produto.getCodProd()+ "&subCategoria="+produto.getSubCategoria().getNomeSubCategoria()
					    			);
					       produtoSubCategoria2.setIcon("fa fa-laptop");
					       
					       produtosDesc.addElement(new DefaultSeparator());

					       produtosDesc.addElement(produtoSubCategoria2);
			    		   }
			    	   }			    	   
		    	   }

		       }
		       if(out) {
		    	   break;
		       }
	    	   

		    		       
		   }
			menuDesc.addElement(produtosDesc);

		
		
		return menuDesc;
	}
	
	public String getEspecTecProd() {
		String especTec = "";
		String nome_produto = getNome();
		
		if(nome_produto != null) {
			especTec = ProdutosBean.especificacaoTecnicasByProd(nome_produto);
		
		}
		
		System.out.println("nome_produtoEspec:"+nome_produto);
		return especTec;
	}
	
	
	public String urlSiteColocacao(String colocacaoSite) {
		//Varrer todos os sites do produto desejado e buscar pela colocação
				Produto prodByName = null ;
				Site site = null;
				boolean out = false;
				String colocacao = colocacaoSite;
				String urlSite = "";
				
				String nome_produto = getNome();
				if(nome_produto != null) {
					prodByName = ProdutosBean.buscarProdutoByName(nome_produto);
					
					
					List<Site> listaSites = ProdutosBean.getSitesByIdProd(prodByName.getCodProd());		
				
					for(int i = 0 ; i < listaSites.size();i++) {
						site  = listaSites.get(i);
						
						  
						  List<RankingSites> rankingSites = site.getRankings();
						  
						  for(int i2 = 0 ; i2 < rankingSites.size();i2++) {
							  String colocacao2= String.valueOf(rankingSites.get(i2).getColocacaoSite());
						  if(colocacao2.equals(colocacao)) {
								  				out = true;
								  				urlSite = site.getUrlSite();
								 				break;
							  }
												  
								  
							  }
							if(out) {
								break;
							}
							
						  }
						  
				
					}
				

				return urlSite;
		
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getsubCat(){
		   return subCat;
		
		}
	
	public static long getcodProd(){
		
		   return Long.parseLong(codProd2);
		
		}
	

	public String getCodProd() {
		return codProd;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public  String getEspecTec() {
		return especTec;
	}

	public static void setEspecTec(String especTec) {
		ManagerParameter.especTec = especTec;
	}
	
	
	public MenuModel getMenu2() {
		return menuDesc;
	}
	
}