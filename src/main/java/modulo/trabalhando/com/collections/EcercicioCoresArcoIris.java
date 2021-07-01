package modulo.trabalhando.com.collections;

import java.util.*;

class ExercicioCoresArcoIris{

    public static void main(String[] args){
         LinkedHashSet<CoresArcoIris> cores = new LinkedHashSet<>() {{
             add (new CoresArcoIris("Violeta"));
             add (new CoresArcoIris("Anil"));
             add (new CoresArcoIris("Azul"));
             add (new CoresArcoIris("Verde"));
             add (new CoresArcoIris("Amarelo"));
             add (new CoresArcoIris("Laranja"));
             add (new CoresArcoIris("Vermelho"));
         }};

         // Exiba todas as cores uma abaixo da outra
         System.out.println("Cores do arco-íris: ");
         imprimeHashSet(cores);

        // A quantidade de cores que o arco-íris tem
        System.out.println("----------\nQuantidade de cores do arco-íris: " + cores.size());

        // Exiba as cores em ordem alfabética
        TreeSet<CoresArcoIris> coresNatural = new TreeSet<>() {{
            add (new CoresArcoIris("Violeta"));
            add (new CoresArcoIris("Anil"));
            add (new CoresArcoIris("Azul"));
            add (new CoresArcoIris("Verde"));
            add (new CoresArcoIris("Amarelo"));
            add (new CoresArcoIris("Laranja"));
            add (new CoresArcoIris("Vermelho"));
        }};
        System.out.println("----------\nCores do arco-íris em ordem alfabética: ");
        imprimeTreeSet(coresNatural);

        // Exiba as cores na ordem inversa da que foi informada
        System.out.println("----------\nCores do arco-íris em ordem inversa: ");
        imprimeOrdemReversaTreeSet(coresNatural);

        // Exiba todas as cores que começam com a letra 'v'
        TreeSet<CoresArcoIris> coresNatural2 = new TreeSet<>() {{
            add (new CoresArcoIris("Violeta"));
            add (new CoresArcoIris("Anil"));
            add (new CoresArcoIris("Azul"));
            add (new CoresArcoIris("Verde"));
            add (new CoresArcoIris("Amarelo"));
            add (new CoresArcoIris("Laranja"));
            add (new CoresArcoIris("Vermelho"));
        }};
        System.out.println("----------\nCores do arco-íris que começam com a letra 'v': ");
        buscaLetraPalavra(coresNatural2, "v", true);

        // Remova todas as cores que não começam com a letra 'v'
        System.out.println("----------\nCores do arco-íris que não começam com a letra 'v': ");
        buscaLetraPalavra(coresNatural2, "v", false);

        // Limpe o conjunto
        coresNatural2.clear();
        System.out.println("----------\nÀrvore de letras limpa: " + coresNatural2);

        // Confira se o conjunto está vazio
        System.out.println("----------\nValidar se a àrvore de letras limpa: " + coresNatural2.isEmpty());
    }

    public static void imprimeHashSet(LinkedHashSet<CoresArcoIris> cores){
        for(CoresArcoIris cor: cores){
            System.out.println(cor.getCor());
        }
    }

    public static void imprimeTreeSet(TreeSet<CoresArcoIris> cores){
        for(CoresArcoIris cor: cores){
            System.out.println(cor.getCor());
        }
    }

    public static void imprimeOrdemReversaTreeSet(TreeSet<CoresArcoIris> cores){
        int tam = cores.size();
            for(int i = 0; i < tam; i++){
                System.out.println(cores.pollLast().getCor());
            }
    }

    public static void buscaLetraPalavra(TreeSet<CoresArcoIris> cores, String letra, boolean tipoBusca){
        // Busca por uma letra que não tem na palavra
            for(CoresArcoIris cor: cores){
                if((cor.getCor().toLowerCase().startsWith(letra.toLowerCase())) && (tipoBusca))
                    System.out.println(cor.getCor());
                else if(!cor.getCor().toLowerCase().startsWith(letra.toLowerCase()) && (!tipoBusca))
                    System.out.println(cor.getCor());
            }
    }
}

