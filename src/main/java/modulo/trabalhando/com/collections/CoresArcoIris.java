package modulo.trabalhando.com.collections;

import java.util.Comparator;
import java.util.Objects;

class CoresArcoIris implements Comparable<CoresArcoIris>{
    String cor;

    public CoresArcoIris(String cor){
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoresArcoIris arcoIris = (CoresArcoIris) o;
        return cor.equals(arcoIris.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor);
    }

    @Override
    public String toString() {
        return "ArcoIris{" +
                "cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(CoresArcoIris cor) {
        return this.getCor().compareToIgnoreCase(cor.getCor());
    }


}

class ComparatorCores implements Comparator<CoresArcoIris> {

    @Override
    public int compare(CoresArcoIris cor1, CoresArcoIris cor2) {
        return cor1.getCor().compareTo(cor2.getCor());
    }

    @Override
    public String toString() {
        return "ComparatorCores{}";
    }
}
