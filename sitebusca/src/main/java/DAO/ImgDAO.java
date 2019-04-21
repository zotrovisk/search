package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Hibernate;
import sitebusca.entity.Img;

public class ImgDAO {

	
	public List<Img> getAllImgs() {
		 List<Img> imgs;
			EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		 	      
	 
			imgs = em.createQuery("select i from Img i", Img.class).getResultList();

	        for(int i = 0 ; i < imgs.size();i++) {
				Img img = imgs.get(i);
				Hibernate.initialize(img.getProdimg());
				
				
			}
	        
	        em.close();	        
	        
	        return imgs;
	}
	

	/*Consultar produtos por subCategoria*/
	public List<Img> getImgByProd(String produtoimg){
		List<Img> listaImagens = new ArrayList<Img>();;
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		listaImagens = em.createQuery("select i FROM Img i WHERE i.prodimg.nomeProd LIKE :nomeprod", Img.class)
		.setParameter("nomeprod", produtoimg).getResultList();
		
		for(int i = 0 ; i < listaImagens.size();i++) {
			Img imagem =listaImagens.get(i);
			Hibernate.initialize(imagem.getProdimg());
		


		}
		
		em.close();
		
		return listaImagens;
	}
	
	
	public Img getImgById(long id) {
		EntityManager em = Util.getEntityManagerInstance().createEntityManager();
		
		Img img = em.getReference(Img.class, id);
		//Hibernate.initialize(img.getProdutoImg());

	return img; 
		
	}
	
	
	
	
}
