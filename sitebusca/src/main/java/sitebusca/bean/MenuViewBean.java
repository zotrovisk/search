package sitebusca.bean;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSeparator;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import sitebusca.entity.Categoria;
import sitebusca.entity.Produto;
import sitebusca.entity.SubCategoria;



@ManagedBean(name ="menuBean")
@SessionScoped

public class MenuViewBean {

	   DefaultSubMenu subCategoria ;
	   DefaultSubMenu categoria ;
	   DefaultMenuItem produtoSubCategoria;
	   DefaultMenuItem produtoSubCategoria2;
	   DefaultMenuItem item;
	   DefaultMenuItem item2;

	   DefaultSubMenu produtosDestaque2;
	   DefaultSubMenu produtosDesc;

	   private MenuModel menu = new DefaultMenuModel();

	   private List<Categoria> categorias;
	   private static List<SubCategoria> subCategorias;
	   private static List<Produto> produtos;
	   private List<Produto> produtosDestaque;

	   
       private MenuModel model = new DefaultMenuModel();
    
    @PostConstruct
    public void init() {
    	categorias = new ArrayList<Categoria>();
    	subCategorias = new ArrayList<SubCategoria>();
    	produtos = new ArrayList<Produto>();
		produtosDestaque =  new ArrayList<Produto>();
    	model = createModel();
    	menu = createMenuDestaque();
		
		
    }     
    
   public MenuModel createModel() {
	   
	   
	  
       //First submenu
	   categorias = ProdutosBean.categorias();
	   subCategorias = ProdutosBean.subCategorias();
	   produtos = ProdutosBean.buscarProdutos();
	   
	   for(int i = 0 ; i < categorias.size();i++) {
		   Categoria categoria2 = categorias.get(i);
		   
		   categoria = new DefaultSubMenu(categoria2.getNomeCategoria());
		   
		   if(i == (categorias.size() - 1)) {
			   categoria.setStyle("height:100px");
		   }
		   
		   
		   for(int i2 = 0 ; i2 < subCategorias.size();i2++){
			   SubCategoria subCategoria2 = subCategorias.get(i2);

		       if(categoria2.getNomeCategoria().equals(subCategoria2.getCodCategoria().getNomeCategoria()) ) {
		    	  subCategoria = new DefaultSubMenu(subCategoria2.getNomeSubCategoria());
		    	  categoria.addElement(subCategoria);
		    	  
		       }
		       
		       for(int i3 = 0 ; i3 < produtos.size(); i3++) {
		    	   Produto produto = produtos.get(i3);
		    	   
		    	   if(produto.getSubCategoria().getNomeSubCategoria().equals(subCategoria2.getNomeSubCategoria())) {
		    		   
		    		

		    		   produtoSubCategoria = new DefaultMenuItem(produto.getNomeProd());
		    		   
		    		   
		    		   
				       produtoSubCategoria.setOutcome(ProdutosBean.redirectDesc(produto));
				       
				       
				       produtoSubCategoria.setIcon("fa fa-laptop");				       
				       subCategoria.addElement(produtoSubCategoria);
		    	   }
		    	   
		    	   
		       }
		       subCategoria = new DefaultSubMenu();
		       
		       
		   }
		   
	       model.addElement(categoria);

	   
	   }
	   
        
        
        return model;
   }
   
   

	public MenuModel createMenuDestaque(){
    	produtosDestaque = ProdutosBean.produtosDestaque();
		
		 produtosDestaque2 = new DefaultSubMenu("Produtos");
		 produtosDestaque2.setStyle("background-color:#5F7AD7");
		 
		for(int i = 0 ; i < produtosDestaque.size();i++) {
			Produto produto = produtosDestaque.get(i);
			
			
			
			item = new DefaultMenuItem(produto.getNomeProd());
			item.setOutcome(ProdutosBean.redirectDesc(produto));
			
			produtosDestaque2.addElement(item);
	
			if(i == 0)
				produtosDestaque2.addElement(new DefaultSeparator());
			
		}
		
		menu.addElement(produtosDestaque2);

		
		
		return menu;
	}
	
	
	
	public static List<Produto> filtraSubCategoria(String subCat){
		List<Produto>  returnProd = new ArrayList<Produto>();
		
		 
		for(int i2 = 0 ; i2 < subCategorias.size();i2++){
			   SubCategoria subCategoria2 = subCategorias.get(i2);
			   
		
			   
		       if(subCategoria2.getNomeSubCategoria().equals(subCat)) {
		    	   
		   
		    	   for(int i3 = 0 ; i3 < produtos.size(); i3++) {
			    	   Produto produto = produtos.get(i3);
					
			    	   if(produto.getSubCategoria().getNomeSubCategoria().equals(subCategoria2.getNomeSubCategoria()) ) {

			    		   
					       returnProd.add(produto);
					       
			    	   }			    	   
		    	   }

		    	   
		       }
		       
		    		       
		   }

		
		
		return returnProd;
	}
	
	  public MenuModel getModel() {
	        return model;
	    }
	    

	public MenuModel getMenu() {
		return menu;
	}
	

    
  
}