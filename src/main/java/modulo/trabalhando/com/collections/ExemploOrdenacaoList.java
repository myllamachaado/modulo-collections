package modulo.trabalhando.com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {

    public static void main(String[] args){
        // Dadas as seguintes informações sobre meus gatos, crie uma lista e ordene a lista exibindo (nome - idade - cor)

        List<Gato> meusGatos = new ArrayList<>();
        Gato gato1 = new Gato("Jon", 18, "Preto");
        meusGatos.add(gato1);
        Gato gato2 = new Gato("Simba", 6, "Tigrado");
        meusGatos.add(gato2);
        Gato gato3 = new Gato("Jon", 12, "Amarelo");
        meusGatos.add(gato3);
        System.out.println("---------\nLista de gatos: " + meusGatos);

        // Ou:

        List<Gato> meusGatos2 = new ArrayList<>(){{
            add(new Gato("Jon", 18, "Preto"));
            add(new Gato("Simba", 6, "Tigrado"));
            add(new Gato("Jon", 12, "Amarelo"));
        }};
        System.out.println("---------\nLista de gatos: " + meusGatos2);

        // 2 - Pela ordem de inserção
        System.out.println("---------\nLista de gatos pela ordem de inserção: " + meusGatos2);

        // 3 - Ordem Aleatória
        Collections.shuffle(meusGatos2);
        System.out.println("---------\nLista de gatos pela ordem aleatória: ");
        System.out.println(meusGatos2);

        // 4 - Ordem natural (nome)
        Collections.sort(meusGatos2);
        System.out.println("---------\nLista de gatos pela natural: " + meusGatos2);

        // 5 -Odem de idade
        Collections.sort(meusGatos2, new ComparatorIdade());
        System.out.println("---------\nLista de gatos pela de idade: " + meusGatos2);

        // 6 - Ordem de cor
        Collections.sort(meusGatos2, new ComparatorCor());
        System.out.println("---------\nLista de gatos pela cor: " + meusGatos2);

        // 7 - Ordem nome/ cor /idade
        Collections.sort(meusGatos2, new ComparatorNomeCorIdade());
        System.out.println("---------\nLista de gatos pela cor: " + meusGatos2);

    }

}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return g1.getIdade().compareTo(g2.getIdade());
    }
}