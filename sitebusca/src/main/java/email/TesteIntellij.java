package email;

import java.util.ArrayList;

public class TesteIntellij {

    ArrayList<String> teste = new ArrayList<>();


    TesteIntellij(){

        for(int i = 0 ; i < 10 ;i++){

            teste.add(String.valueOf(i));

            System.out.println(teste.get(i));

        }

    }

    public static  void teste(){

        TesteIntellij teste = new TesteIntellij();

    }

    public static void main(String args[]){
        teste();
        System.out.println("");
    }

}
