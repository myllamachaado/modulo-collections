package modulo.trabalhando.com.collections;

import java.util.Objects;

class ArcoIris implements Comparable<ArcoIris>{
    String cor;

    public ArcoIris(String cor){
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public int compareTo(ArcoIris o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArcoIris arcoIris = (ArcoIris) o;
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
/*    @Override
    public int compare(ArcoIris cor1, ArcoIris cor2) {
        return - cor1.getCor().compareTo(cor2.getCor());
    }
*/
}
