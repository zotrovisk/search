package sitebusca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import DAO.CategoriaDAO;
import DAO.EspecificacaoTecnicaDAO;
import DAO.ImgDAO;
import DAO.ProdutoDAO;
import DAO.SiteDAO;
import DAO.SubCategoriaDAO;
import sitebusca.entity.Categoria;
import sitebusca.entity.EspecificacaoTecnica;
import sitebusca.entity.Img;
import sitebusca.entity.Produto;
import sitebusca.entity.RankingSites;
import sitebusca.entity.Site;
import sitebusca.entity.SiteProduto;
import sitebusca.entity.SubCategoria;

 
@ManagedBean(name ="prodBean")
@SessionScoped

public class ProdutosBean implements Serializable {
     
 
	private static final long serialVersionUID = 2302954996924160336L;

	public static List<Produto> produto = new ArrayList<Produto>();
	private  List<Produto> favoritos = new ArrayList<>();
	public static List<Categoria> categorias;
    public static List<SubCategoria> subCategorias;
    public static List<Produto> produtosDestaque;
	
    private Produto selectedProd;
    
    public static long codProduto;
    
    private static ProdutoDAO produtoDAO ;
    private static SubCategoriaDAO subCategoriaDAO ;
    private static CategoriaDAO categoriaDAO ;
    private static EspecificacaoTecnicaDAO especificacaoTecnicaDAO ;
    private static SiteDAO siteDAO;
    private static ImgDAO imgDAO;

    @PostConstruct
    public void init() {
    	System.out.println("teste......");
    	imgDAO = new ImgDAO();
    	produtoDAO = new ProdutoDAO();
    	subCategoriaDAO = new SubCategoriaDAO();
    	categoriaDAO = new CategoriaDAO();
    	especificacaoTecnicaDAO = new EspecificacaoTecnicaDAO();
    	siteDAO = new SiteDAO();
    	produto = buscarProdutos();
    	setFavoritos(produtosfavoritados());
    	
    }
 
    public List<Produto> getProds() {
        return produto;
    }
    
	
    
    public static List<SubCategoria> categoriaBySubCategoria() {
    	
    	List<SubCategoria> listaSubCategoria;
    	 listaSubCategoria = categoriaDAO.getSubCategoriaByCategoria("Hardware");
    
    	
    	return listaSubCategoria;
    }
    
    public void updateProd(Produto produto) {
    	try {
			produtoDAO.updateProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public static List<Site> getSitesByIdProd(long idProd) {
    	List<Site> listaSites= siteDAO.getSitesByProdId(idProd); 	
    	
    	
    	return listaSites;
    }
    
    
    public static String getPrecoBySiteAndProdId(long idProd,long idSite) {
    	String precoProd= siteDAO.getPrecoByProdIdAndSiteId(idProd,idSite);
    	
    	
    	
    	
    	return precoProd;
    }
    
    public static String  getImgByProd(String nomeProd) {
    	 List<Img> listaimg = imgDAO.getImgByProd(nomeProd);
    	 String img  = "";
    	 if(listaimg.size() > 0) {
    		 img = listaimg.get(0).getUrlImg();
    	 }
    
    	 for(int i = 0 ; i < listaimg.size();i++) {
    		System.out.println("imgurl: "+listaimg.get(i).getUrlImg());
    	 }
    	 return img;
    }
  
    
    public Produto selectdMinCont() {
    	
    	Produto produto = new Produto();
    	try {
    		List<Produto> listaProduto = produtoDAO.selectProdMinCont();
    		if(listaProduto.size() > 1) {
    			produto = listaProduto.get(0);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    
    	
    	return produto;
    }
    
    public static List<Produto> produtosBegin(String begin) {
    	List<Produto> listaProdutos;
    	 listaProdutos = produtoDAO.getProdutosBegin(begin);
    	
    	
    	return listaProdutos;
    }
    
    
    public static List<Produto> produtosByPreco(String preco) {
    	List<Produto> listaProdutos;
    	 listaProdutos = produtoDAO.getProdutosByPreco(preco);
    	
    	
    	return listaProdutos;
    }
    
    
    public static List<EspecificacaoTecnica> especificacaoTecnicas(){
    	List<EspecificacaoTecnica> listaEspec;
    	listaEspec = especificacaoTecnicaDAO.getAllEspecTec();    	
    	
    	return listaEspec;
    }
    
    public static String especificacaoTecnicasByProd(String nomeProd){
    	String espec = "";
    	List<EspecificacaoTecnica> listaEspc;
    	listaEspc = especificacaoTecnicaDAO.getEspecByProd(nomeProd);    	
    	
    	for(int i = 0 ; i <listaEspc.size();i++) {
    		System.out.println("especLista"+listaEspc.get(i));
    	}
    	if(listaEspc.size() > 0) {
    		espec = listaEspc.get(0).getNomeEspecificacaoTecnica();
    	}
    	
    	return espec;
    }
    
    public static List<Site> sites(){
    	List<Site> listasites;
    	listasites = siteDAO.getAllSitesTec();    	
    	
    	return listasites;
    }
    
    public static List<Site> sitesByProduto(){
    	List<Site> listasites;
    	listasites = siteDAO.getAllSitesTec();
     	
    	return listasites;
    }
    
    public static List<Produto>  buscarProdutos() {
    	List<Produto> listaProdutos;

    	 listaProdutos = produtoDAO.getAllProdutos();
    
    
    	
    	return listaProdutos;
    }
    
    public static Produto  buscarProdutoByID(long codProd) {
    	Produto produto;
    	produto = produtoDAO.getProdutoById(codProd);
    	
    	return produto;
    }
    
    
    
    public static Produto  buscarProdutoByName(String nomeProd) {
    	Produto produto;
    	produto = produtoDAO.getProdutoByName(nomeProd);
    	
    	return produto;
    }
    
    public static List<Produto> produtosfavoritados() {
    	List<Produto> listaProdutoFavoritoss;

    	listaProdutoFavoritoss = produtoDAO.getProdutosFavoritos();

    	
    	return listaProdutoFavoritoss;
    }
    
    
    
    public static List<SubCategoria> subCategorias() {
    	List<SubCategoria> listasubCategorias;

       	listasubCategorias = subCategoriaDAO.getAllSubCategorias();
   
    	
    	return listasubCategorias;
    }
    
    public static List<Categoria> categorias() {
    	List<Categoria> listaCategorias;
    	
       	listaCategorias = categoriaDAO.getAllCategorias();
    	
    	
    	return listaCategorias;
    }
    
  
    
    public static List<Produto> produtosDestaque() {
    	List<Produto> listaProdutosDestaque;
    	listaProdutosDestaque = produtoDAO.getProdutosDestaque();

    	
    	return listaProdutosDestaque;
    	
    }
    
    public Produto getSelectedProd() {
        return selectedProd;
    }
 
    public void setSelectedProd(Produto selectedProd) {
        this.selectedProd = selectedProd;
    }
    
    public static String redirectDesc(Produto produto) {
 		codProduto = produto.getCodProd();

 		
    	return "descricaoView?faces-redirect=true&nome="+produto.getNomeProd()
    			    			
    			+ "&codProd="+produto.getCodProd() + "&subCategoria="+produto.getSubCategoria().getNomeSubCategoria()
    			
    			;
       
    }
    
    public static String urlImg(String nomeProd) {
		Produto prodByName = null ;
		Img img = null;
		String urlImg = "";
		
		String nome_produto = nomeProd;
		
		if( nome_produto != null) {

		 urlImg = ProdutosBean.getImgByProd(nome_produto);		

		}
	

		return urlImg;
	}
    
    public static String redirectDesc3(String param) {

 		
    	return "descricaoView?faces-redirect=true&nome="+param;
       
    }
    
    public String getRedirectFavorito() {

 		
    	return "favoritosView?faces-redirect=true";
       
    }
    
    public String getRedirectHome() {
 		
    	return "homeView?faces-redirect=true";
       
    }
    
 public String getPathPolitica() {

 		
    	return "politicaView?faces-redirect=true";
       
    }
 

    
 public static String redirectDesc2(Produto produto) {
 		codProduto = produto.getCodProd();
    	
    	return "&nome="+produto.getNomeProd()
    			
    			+ "&precoProd=+produto.getPrecoProd()"
    			
    			+ "&codProd="+produto.getCodProd() + "&subCategoria="+produto.getSubCategoria().getNomeSubCategoria()
    			
    			;
    	
       
    }
 
    
    /*Reculperando produto e incrementando o contFavorito*/
    public void favoritar() {
    	

    	
    	long codProd = ManagerParameter.getcodProd();
    	Produto prod = buscarProdutoByID(codProd);
    	long contFavorito = prod.getContFavorito();
    	contFavorito++;
    	prod.setContFavorito(contFavorito);
    	
    	updateProd(prod);
    		
    	
    	Produto prodretorno = buscarProdutoByID(codProd);
    	
    	
    
    	
    	setFavoritos(produtosfavoritados());
    	
      
    	
 }

	public List<Produto> getFavoritos() {
		return favoritos;
	}

	public  void setFavoritos(List<Produto> favoritos) {
		this.favoritos = favoritos;
	}
 
    
	public List<Site> getSitesByProd(Produto produto) {
	    List<Site> sites = new ArrayList<Site>();
	 	      

		List<SiteProduto> listaSites = produto.getSites();			

		
		for(int i = 0 ; i < listaSites.size();i++) {
			Site ps = listaSites.get(i).getSite();
			
			  Site site = ps;
			  sites.add(site);
		}
		
        return sites;
}
 
	
	public String precoProd(Produto produto) {
		//Varrer todos os sites do produto desejado e buscar pela colocação
				Produto prodByName = null ;
				Site site = null;
				String precoProduto = "";
				boolean out = false;
				String colocacao = "1";
				
				String nome_produto =  produto.getNomeProd();
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
								  				precoProduto = ProdutosBean.getPrecoBySiteAndProdId(prodByName.getCodProd(), site.getCodSite());
								 				break;
							  }
												  
								  
							  }
							if(out) {
								break;
							}
							
						  }
						  
				
					}
				

				return precoProduto;
		
	}
    
	
	
	public String urlSite(Produto produto) {
		//Varrer todos os sites do produto desejado e buscar pela colocação
				Produto prodByName = null ;
				Site site = null;
				boolean out = false;
				String colocacao = "1";
				String urlSite = "";
				
				String nome_produto =  produto.getNomeProd();
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
    
  
    
    
}