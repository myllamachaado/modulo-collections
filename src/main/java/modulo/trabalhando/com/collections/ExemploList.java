package modulo.trabalhando.com.collections;

import java.util.*;

public class ExemploList {

    public static void main(String[] args){
        // 1 - Crie uma lista com sete notas:
        List<Double> notas = new ArrayList<>();

        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println("Lista de notas: " + notas);

        // 2 - Exiba a posição da nota 5
        int index = notas.indexOf(5.0);
        if(index >= 0){
            System.out.println("----------\n A posição do item 5.0 é: " + index);
        }
        else{
            System.out.println("----------\n A nota não existe na lista");
        }

        // 3 - Adicione na lista a nota 8.0 na posição 4
        notas.add(4, 8.0);
        System.out.println("----------\n Lista de notas atualizado: " + notas);

        // 4 - Substitua a nota 5.0 pela nota 6.0
        index = notas.indexOf(5.0);
        if(index >= 0){
            notas.set(index, 6.0);
            System.out.println("----------\n Lista após a atualização de nota: " + notas);
        }
        else{
            System.out.println("----------\n Não existe essa nota na lista, item não substituído");
        }

        // 5 - Confira se a nota 5 está na lista
        //notas.contains(5.0);
        index = notas.indexOf(5.0);
        if(index >= 0){
            System.out.println("----------\n A nota 5.0 está presente no index: " + index);
        }
        else{
            System.out.println("----------\n Não existe a nota 5.0 na lista.");
        }

        // 6 - Exiba todas as notas na ordem em que foram informadas
        System.out.println("----------\n Lista de notas: " + notas);

        // 7 - Exiba a terceira nota adicionada
        System.out.println("----------\n A terceira nota adicionada é a nota: " + notas.get(3));

        // 8 - Exiba a menor nota
        System.out.println("----------\n A menor nota: " + Collections.min(notas));

        // 9 - Exiba a maior nota
        System.out.println("----------\n A maior nota: " + Collections.max(notas));

        // 10 - Exiba a soma dos valores
        Double soma = 0.0;
        for(Double linha: notas){ //Usando for
            soma += linha;
        }
        System.out.println("----------\n A soma das notas (usando for) é: " + soma);

        soma = 0.0;
        Iterator<Double> iterator = notas.iterator();
        while(iterator.hasNext()){
            soma+=iterator.next();
        }
        System.out.println("----------\n A soma das notas (usando iterator) é: " + soma);

        // 11 - Exiba a média das notas
        System.out.println("----------\n A média das notas é: " + soma/notas.size());

        // 12 - Remova a nota 0
        notas.remove(0.0);
        System.out.println("----------\n Lista de notas após remoção: " + notas);


        // 13 - Remova a nota da posição 0
        notas.remove(0);
        System.out.println("----------\n Lista de notas após remoção do index 0: " + notas);

        // 14 - Remova as notas menores que 7 e exiba as notas
        notas.removeIf(nota -> nota < 7);
        System.out.println("----------\n Lista de notas após remoção das notas menores que 7: " + notas);

        // 15 - Apague toda a lista e confira se a lista está vazia
        //notas.clear();
        //System.out.println("----------\n Lista de notas após a limpeza: " + notas.isEmpty());

        //PARTE 2
        // 1 - Crie uma lista chamada notas2 e coloque todos os elementos da list ArrayList nessa nova lista
        LinkedList<Double> notas2 = new LinkedList<>();
        notas2.addAll(notas);
        System.out.println("----------\n Lista de notas2 após cópia " + notas2);

        //Mostre a primeira nota da nova lista sem remover
        System.out.println("----------\n Lista de notas2 após método peek() " + notas2.peek());
        System.out.println(notas2);

        //Mostre a primeira nota da nova lista removendo-a
        System.out.println("----------\n Lista de notas2 após método poll() " + notas2.poll());
        System.out.println(notas2);


    }
}
