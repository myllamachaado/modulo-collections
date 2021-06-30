package modulo.trabalhando.com.collections;

import java.util.Comparator;
import java.util.Objects;

class Serie implements Comparable<Serie> {
    String nome;
    String genero;
    Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio){
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;
        return this.getGenero().compareToIgnoreCase(serie.getGenero());
    }
}

class ComparatorTempo implements Comparator<Serie> {
    @Override
    public int compare(Serie serie1, Serie serie2) {
        int tempo = serie1.getTempoEpisodio().compareTo(serie2.getTempoEpisodio());
        if(tempo != 0) return tempo;
        return serie1.getNome().compareTo(serie2.getNome());
    }
}

class ComparatorGenero implements Comparator<Serie> {
    @Override
    public int compare(Serie serie1, Serie serie2) {
        return serie1.getGenero().compareTo(serie2.getGenero());
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie> {
    @Override
    public int compare(Serie serie1, Serie serie2) {
        int nome = serie1.getNome().compareToIgnoreCase(serie2.getNome());
        if (nome != 0) return nome;

        int genero = serie1.getGenero().compareToIgnoreCase(serie2.getGenero());
        if (genero != 0) return genero;

        return serie1.getTempoEpisodio().compareTo(serie2.getTempoEpisodio());
    }
}