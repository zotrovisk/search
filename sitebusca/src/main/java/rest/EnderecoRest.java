package rest;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import sitebusca.entity.Endereco;

public class EnderecoRest  implements Serializable{
	
	private static final long serialVersionUID = -4953265617464977321L;

 
	public static Endereco buscarEnderecoPorUrl() {
	String urlJson = "https://viacep.com.br/ws/72120390/json";
	
	 Endereco endereco = new Endereco();
	 Client cliente = Client.create();
	 WebResource wr = cliente.resource(urlJson);
	 
	 	
	 final	GsonBuilder gsonBuilder = new GsonBuilder(); 
	 final Gson gson = gsonBuilder.create();	
	 endereco = gson.fromJson(wr.get(String.class),Endereco.class); 
	 System.out.println(wr.get(String.class));
	 
	 return endereco;
		
	}
	
	public static  void digestMd5() {
		 String hash = "ffd275c5130566a2916217b101f26150";
		 String ts = "01112018112411";
		 String publicKey ="d52580596b8a2338156bab306595dcf6";
		 String privateKey ="a97afc6972ac63d4bde46da56401b1ead4e24e7a";
		 String concat = ts+publicKey+privateKey;
		 System.out.println(concat);
		 
		 
		    MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    md.update(concat.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter
		      .printHexBinary(digest).toLowerCase();
		    
		     
		    System.out.println(myHash);
	}
	
	public static void main(String[] args) {
		Endereco endereco = buscarEnderecoPorUrl();
		System.out.println(endereco.toString());
		//digestMd5();
		
		
	}
	
}