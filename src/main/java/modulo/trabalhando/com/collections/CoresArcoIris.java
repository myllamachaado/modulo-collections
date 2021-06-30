package modulo.trabalhando.com.collections;

import java.util.*;

public class CoresArcoIris{

    public static void main(String[] args){
         LinkedHashSet<ArcoIris> cores = new LinkedHashSet<>() {{
             add (new ArcoIris("Violeta"));
             add (new ArcoIris("Anil"));
             add (new ArcoIris("Azul"));
             add (new ArcoIris("Verde"));
             add (new ArcoIris("Amarelo"));
             add (new ArcoIris("Laranja"));
             add (new ArcoIris("Vermelho"));
         }};

         // Exiba todas as cores uma abaixo da outra
         System.out.println("Cores do arco-íris: ");
         imprimeHashSet(cores);
         System.out.println("Cores do arco-íris: " + cores);


        // A quantidade de cores que o arco-íris tem
        System.out.println("----------\nQuantidade de cores do arco-íris: " + cores.size());

        // Exiba as cores em ordem alfabética
        TreeSet<String> coresAlfabetica = new TreeSet<>();
        coresAlfabetica.add("Violeta");
        coresAlfabetica.add("Anil");
        coresAlfabetica.add("Azul");
        coresAlfabetica.add("Verde");
        coresAlfabetica.add("Amarelo");
        coresAlfabetica.add("Laranja");
        coresAlfabetica.add("Vermelho");
        System.out.println("----------\nCores do arco-íris em ordem alfabética: " + coresAlfabetica);

        // Exiba as cores na ordem inversa da que foi informada
        //Collections.sort(cores);
        System.out.println("----------\nCores do arco-íris em ordem inversa: " + coresAlfabetica);

        // Exiba todas as cores que começam com a letra 'v'

        // Remova todas as cores que não começam com a letra 'v'

        // Limpe o conjunto

        // Confira se o conjunto está vazio



    }

    public static void imprimeHashSet(LinkedHashSet<ArcoIris> cores){
        for(ArcoIris cor: cores){
            System.out.println(cor.getCor());
        }
    }

    public static void imprimeTreeSet(TreeSet<String> cores){
        for(String cor: cores){
            System.out.println(cor);
        }
    }

}

