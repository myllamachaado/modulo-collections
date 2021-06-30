package modulo.trabalhando.com.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {
    // Dadas as seguintes informaões sobre minhas sérias favoritas, crie um conjunto e ordene este conjunto exibindo: (nome - genero - tempo de episódio);

    // Série 1 = nome: got, genero: fantasia, tempoEpisodio: 60
    // Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
    // Série 3 = nome: that 70's show, genero: comédia, tempoEpisodio: 25

    public static void main(String[] args){
        // Ordem aleatória
        HashSet<Serie> series = new HashSet<>(){{
            add( new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's show", "comedia", 25));
        }};

        System.out.println("----------\nOrdem aleatória: ");
        imprimeHashSet(series);

        // Ordem de inserção
        LinkedHashSet<Serie> seriesHashSet = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's show", "comedia", 25));
        }};

        System.out.println("----------\nOrdem de inserção: ");
        imprimeLinkedHashSet(seriesHashSet);

        // Ordem natural
        TreeSet<Serie> seriesTreeSet = new TreeSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's show", "comedia", 25));
        }};

        System.out.println("----------\nOrdem natural inserção: ");
        imprimeTreeSet(seriesTreeSet);

        System.out.println("----------\nOrdem por genero: ");
        TreeSet<Serie> seriesGenero = new TreeSet<>(new ComparatorGenero());
        seriesGenero.addAll(seriesTreeSet);
        imprimeTreeSet(seriesGenero);

        System.out.println("----------\nOrdem por tempo de episódio: ");
        TreeSet<Serie> seriesTempo = new TreeSet<>(new ComparatorTempo());
        seriesTempo.addAll(seriesTreeSet);
        imprimeTreeSet(seriesTempo);


        System.out.println("----------\nOrdem Nome / Genero / Tempo Episodio: ");
        TreeSet<Serie> seriesNomeGeneroTempo = new TreeSet<>(new ComparatorNomeGeneroTempo());
        seriesNomeGeneroTempo.addAll(seriesTreeSet);
        imprimeTreeSet(seriesNomeGeneroTempo);
    }

    private static void imprimeHashSet(HashSet<Serie> series){
        for(Serie serie: series){
            System.out.println(
                    "nome: " + serie.getNome() +
                    " - genero: " + serie.getGenero() +
                    " - tempo episódio: " + serie.getTempoEpisodio()
            );
        }
    }

    private static void imprimeLinkedHashSet(LinkedHashSet<Serie> series){
        for(Serie serie: series){
            System.out.println(
                    "nome: " + serie.getNome() +
                            " - genero: " + serie.getGenero() +
                            " - tempo episódio: " + serie.getTempoEpisodio()
            );
        }
    }

    private static void imprimeTreeSet(TreeSet<Serie> series){
        for(Serie serie: series){
            System.out.println(
                    "nome: " + serie.getNome() +
                            " - genero: " + serie.getGenero() +
                            " - tempo episódio: " + serie.getTempoEpisodio()
            );
        }
    }

}

