package modulo.trabalhando.com.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class Livro {
    String titulo;
    int numPaginas;

    public Livro(String titulo, int numPaginas){
        this.titulo = titulo;
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livros = (Livro) o;
        return numPaginas == livros.numPaginas && titulo.equals(livros.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, numPaginas);
    }

    @Override
    public String toString() {
        return "Livros{" +
                "titulo='" + titulo + '\'' +
                ", numPaginas=" + numPaginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getTitulo().compareTo(l2.getValue().getTitulo());
    }
}

class ComparatorNumeroPaginas implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getNumPaginas(),l2.getValue().getNumPaginas());
    }
}

