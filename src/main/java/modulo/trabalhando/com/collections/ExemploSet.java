package modulo.trabalhando.com.collections;

import java.util.*;

public class ExemploSet {
    // Set notas = new HashSet(); -> Antes do java 5
    // Set<Double> notas = new HashSet<>(); -> Generics (jdk 5), diamond operator
    // HashSet<Double> notas = new HashSet<>();
    // Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
    // Set<Double> notas = Set.of(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6);

    public static void main(String[] args){
        //Crie uma lista com 7 notas
        Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println("----------\n Conjunto de notas: " + notas);

        // Exiba a posição da nota 5.0

        // Adicione na lista a nota 8.0 na posição 4

        // Substitua a nota 5.0 pela nota 6.0

        // Confira se a nota 5.0 está no conjunto
        System.out.println("----------\n A nota 5.0 está no conjunto notas? " + notas.contains(5.0));

        // Exiba a terceira nota adicionada

        // Ebiba a menor nota
        System.out.println("----------\n A maior nota é: " + Collections.max(notas));

        // Ebiba a maior nota
        System.out.println("----------\n A menor nota é: " + Collections.min(notas));

        // Exiba a soma dos valores
        Double soma = somaNotaFor(notas);
        System.out.println("----------\n " + String.format("A soma das notas é: %.2f", soma));

        // Exiba a média das notas
        System.out.println("----------\n " + String.format("A média das notas é: %.2f", mediaNotas(soma, notas.size())));

        // Remova a nota 0.0
        notas.remove(0.0);
        System.out.println("----------\n Conjunto de notas após remoção da nota 0.0: " + notas);

        // Remova a nota da posição 0


        // Remova as notas menores que 7 e exiba as notas
        notas.removeIf(nota -> nota < 7);
        System.out.println("----------\n Conjunto de notas após remover notas menores que 7.0: " + notas);

        // Mostrar as notas na ordem em que foram informadas
        LinkedHashSet<Double> notasLinked = new LinkedHashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println("----------\n Conjunto de notas na ordem de inserção: " + notasLinked);

        // Exiba as notas na ordem crescente
        TreeSet<Double> notas3 = new TreeSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println("----------\n Conjunto de notas na ordem crescente: " + notas3);

        // Apague toda a lista
        notas.clear();
        System.out.println("----------\n Conjunto de notas após clear: " + notas);

        // Confira se a lista está vazia
        System.out.println("----------\n Lista vazia? " + notas.isEmpty());
    }

    public static Double somaNotaFor(Set<Double> notas){
        Double soma = 0.0;
        for(Double nota: notas){
            soma += nota;
        }
        return soma;
    }

    public static Double somaNotaIterator(Set<Double> notas){
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        Double next = 0.0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        return soma;
    }


    public static Double mediaNotas(Double soma, Integer quantidade) {
        return soma/quantidade;
    }
}



