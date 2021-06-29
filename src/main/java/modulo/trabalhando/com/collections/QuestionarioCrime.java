package modulo.trabalhando.com.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionarioCrime {
    // Utilizando listas faça um programa que faça cinco perguntas a uma pessoa sobre um crime.
    // Se a pessoa responder positivamente a duas questões ela deve ser categorizada como suspeita
    // entre três e quatro como cumplice e cinco como assassino. Caso contrário ele é inocente.

    public static void main(String[] args) throws IOException {
    List<Integer> perguntas = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String aux;

    System.out.println("Telefonou pra vitma? [SIM 1 | NÃO 0]");
    aux = br.readLine();
    perguntas.add(0, Integer.parseInt(aux));
    System.out.println("Esteve no local do crime? [SIM 1 | NÃO 0]");
    aux = br.readLine();
    perguntas.add(1, Integer.parseInt(aux));
    System.out.println("Mora perto da vítma? [SIM 1 | NÃO 0]");
    aux = br.readLine();
    perguntas.add(2, Integer.parseInt(aux));
    System.out.println("Devia para a vítma? [SIM 1 | NÃO 0]");
    aux = br.readLine();
    perguntas.add(3, Integer.parseInt(aux));
    System.out.println("Já trabalhou com a vítma? [SIM 1 | NÃO 0]");
    aux = br.readLine();
    perguntas.add(4, Integer.parseInt(aux));

    Integer contagem = contagemSuspeito(perguntas);
    if(contagem== 2)
        System.out.println("Você foi categorizado como suspeito!");
    else if(contagem == 3 || contagem == 4)
        System.out.println("Você foi categorizado como cumplice!");
    else if(contagem == 5)
            System.out.println("Você foi categorizado como assassino!");
    else
            System.out.println("Você foi categorizado como inocente!");

    }

    public static Integer contagemSuspeito(List<Integer> perguntas){
        Integer cont = 0;
        for(Integer linha: perguntas){
            if(linha == 1){
                cont++;
            }
        }
        return cont;
    }

}
