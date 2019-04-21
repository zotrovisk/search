package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Hibernate;
import sitebusca.entity.Produto;




public class ProdutoDAO {

	public ProdutoDAO() {}
	
	/*Reculpera todos os produtos*/
	public List<Produto> getAllProdutos() {
		 List<Produto> listaProduto;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
	        System.out.println("Recuperando os dados:");
	        listaProduto = em.createQuery("select distinct p from Produto p", Produto.class).getResultList();
	        System.out.println(listaProduto);
	        
	        for(int i = 0 ; i < listaProduto.size();i++) {
				Produto produto =listaProduto.get(i);
				Hibernate.initialize(produto.getSubCategoria());
				Hibernate.initialize(produto.getSites());

				
			}
	        
	        em.close();	        
	        
	        return listaProduto;
	}
	
	public Produto getProdutoById(long codProd) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
	
		Produto prod = em.getReference(Produto.class, codProd);
		
		Hibernate.initialize(prod.getSubCategoria());
		Hibernate.initialize(prod.getSites());

		em.close();	
		
		return prod; 
		
	}
	
	/*Gambis*/
	public Produto getProdutoByName(String prodName ) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		Produto produto;
		List<Produto> prod = em.createQuery("select p from Produto p WHERE p.nomeProd LIKE :nome", Produto.class)
				
				.setParameter("nome",prodName)
				
				.getResultList();
		produto = prod.get(0);
		
		Hibernate.initialize(produto.getSubCategoria());
		Hibernate.initialize(produto.getSites());

		em.close();	
		
		return produto; 
		
	}
	
	
	public void updateProduto(Produto produto) throws Exception {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
 
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
 
            throw new Exception(e);
        } finally {
            em.close();
        }
    }
	
	public List<Produto>  selectProdMinCont() throws Exception {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		List<Produto> listaProdutos;

		listaProdutos = em.createQuery("select p from Produto p WHERE  p.contFavorito = (select min(c.contFavorito) from Produto c)", Produto.class).getResultList();
		
		for(int i = 0 ; i < listaProdutos.size();i++) {
			Produto produto =listaProdutos.get(i);
			Hibernate.initialize(produto.getSubCategoria());
			Hibernate.initialize(produto.getSites());

			
		}
		em.close();	
		
		return listaProdutos; 
    }
	
	/*Consultar produtos por subCategoria*/
	public List<Produto> getProdutosBySubCategoria(String subcategoria){
		List<Produto> listaProdutos;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaProdutos = em.createQuery("select s FROM Produto s WHERE s.subCategoria.nomeSubCategoria LIKE :nomesub", Produto.class)
		.setParameter("nomesub", subcategoria).getResultList();
		
		for(int i = 0 ; i < listaProdutos.size();i++) {
			Produto produto =listaProdutos.get(i);
			Hibernate.initialize(produto.getSubCategoria());
			Hibernate.initialize(produto.getSites());

			
		}
		
		em.close();
		
		return listaProdutos;
	}

	
	
	
	/*Consulta todos os produtos que iniciam com a entrada do usuário*/
	public List<Produto> getProdutosBegin(String nome){
		List<Produto> listaProdutos;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaProdutos = em.createQuery("select p from Produto p WHERE p.nomeProd LIKE CONCAT(:nomeProduto,'%')", Produto.class)
		.setParameter("nomeProduto", nome).getResultList();
		
		for(int i = 0 ; i < listaProdutos.size();i++) {
			Produto produto =listaProdutos.get(i);
			Hibernate.initialize(produto.getSubCategoria());
			Hibernate.initialize(produto.getSites());

			
		}
		
		em.close();
		
		return listaProdutos;
	}
	
	public List<Produto> getProdutosDestaque(){
		List<Produto> listaProdutos;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaProdutos = em.createQuery("select p from Produto p WHERE p.produtoDestaque = 1", Produto.class).getResultList();
		
		for(int i = 0 ; i < listaProdutos.size();i++) {
			Produto produto =listaProdutos.get(i);
			Hibernate.initialize(produto.getSubCategoria());
			Hibernate.initialize(produto.getSites());

			
		}
		
		em.close();
		
		return listaProdutos;
	}
	
	public List<Produto> getProdutosFavoritos(){
		List<Produto> listaProdutos = new ArrayList<Produto>();
		List<Produto> listaProdutos2 = new ArrayList<Produto>();
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaProdutos = em.createQuery("select p from Produto p WHERE p.contFavorito >= 10 ORDER BY p.contFavorito DESC", Produto.class).getResultList();
		
		for(int i = 1 ; i < 11;i++) {
			if(listaProdutos.size() >= i) {
				Produto produto =listaProdutos.get(i-1);
				Hibernate.initialize(produto.getSites());
				Hibernate.initialize(produto.getSubCategoria());
				listaProdutos2.add(produto);
			}
		
			
		}
		
		em.close();
		
		return listaProdutos2;
	}
	
	
	public List<Produto> getProdutosByPreco(String preco){
		List<Produto> listaProdutos;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaProdutos = em.createQuery("select distinct s.produtos FROM SiteProduto s" + 
				" WHERE s.precoProduto LIKE CONCAT(:precoProd,'%') ", Produto.class)
		.setParameter("precoProd", preco).getResultList();

		
		for(int i = 0 ; i < listaProdutos.size();i++) {
			Produto produto =listaProdutos.get(i);
			Hibernate.initialize(produto.getSubCategoria());
			Hibernate.initialize(produto.getSites());

			
		}
		
		em.close();
		
		return listaProdutos;
		
	}

	
	
	
}
