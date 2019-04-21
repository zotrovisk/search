package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Expressao {
  
    
    private void show(String inputEmail, String mask) {
        Pattern pattern = Pattern.compile(mask);
        String email = inputEmail;
       
        
                Matcher matcher = pattern.matcher(email);
                System.out.println(email + " : " + matcher.matches());
                matcher = pattern.matcher(email.toUpperCase());
                System.out.println(email.toUpperCase() + " : " + matcher.matches());
          
    }
    
    private void start() {
    	
        String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";
        
        String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";
        
        String at = "@";
        String emailMask = nameMask + at + domainMask;
        show("leo@gmail.com", emailMask);
  
    }
    /*teste1*/
    public static void main(String[] args) {
        new Expressao().start();
    }
}
