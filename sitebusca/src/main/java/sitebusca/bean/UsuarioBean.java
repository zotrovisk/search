package sitebusca.bean;

import java.util.List;

import DAO.UsuarioDAO;
import sitebusca.entity.Usuario;


public class UsuarioBean   {

	private static final long serialVersionUID = 714172821044259753L;
	
	private static UsuarioDAO usuarioDAO;	
	
	 public static List<Usuario> buscarUsuarios() {
				 
		 	    List<Usuario> usuario = null;
		 	    			
	    		String  teste6 = "vazio";

	    		try {
	    		
	    		usuarioDAO = new UsuarioDAO();
	    		
	    	    usuario = usuarioDAO.getUsuarios();
	    	    
	    	    System.out.println("usuario: "+usuario);
	    	    
	    	    for(int i = 0 ; i < usuario.size();i++) {
	    	    			
	    	    	 Usuario usuX = usuario.get(i);
	    	    	 
	    	    	 System.out.println("usuario: "+" "+i+usuario.get(i).getNomeUsu());
	    	    	 
	    	    	
	    	    	 	
	    	    }
	    	    
	    	   
	    			
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
	    		
	    		System.out.println("buscarUsuarios2: "+teste6);
	    		

	    	return usuario;
	    
	 }
	
	 
	 
	 
	 
}
