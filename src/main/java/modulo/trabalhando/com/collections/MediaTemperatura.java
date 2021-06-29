package modulo.trabalhando.com.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaTemperatura {
    // Faça um programa que receba a temperatura media  dos 6 primeiros meses do ano e armazene-os em um alista.
    // Após isso calcule a média semestral das temperaturas e mostre toda sas temperaturas acima dessa média e
    // o mês em que elas ocorreram (mostrar o mês por extenso)
    public static void main(String[] args) throws IOException {
        List<Double> mediaTemperaturas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i =0; i < 6; i++) {
            System.out.println("Insira a temperatura do mês 0" + (i+1) + ": ");
            String aux = br.readLine();
            mediaTemperaturas.add(Double.parseDouble(aux));
        }
        System.out.println("--------\n Lista de temperaturas: " + mediaTemperaturas);
        System.out.println("--------\n A soma das temperaturas: " + somaMedias(mediaTemperaturas));
        System.out.println("--------\n" + String.format("A média semestral das temperaturas: %.2f", mediaDasMedias(mediaTemperaturas)));

        Double media = mediaDasMedias(mediaTemperaturas);
        System.out.println("--------\n Meses em que a temperatura média do mês é maior que a média semestral:");
        exibeValorAcimaMediaSemestral(mediaTemperaturas, media);
    }

    public static Double somaMedias(List<Double> mediaTemperaturas){
        Double soma = 0.0;
        for(Double mes: mediaTemperaturas){
            soma +=mes;
        }
        return soma;
    }

    public static Double mediaDasMedias(List<Double> mediaTemperaturas){
        return somaMedias(mediaTemperaturas)/mediaTemperaturas.size();
    }

    public static List<Double> exibeValorAcimaMediaSemestral(List<Double> mediaTemperaturas, Double media){
        List<String> meses = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho");
        int i = 0;
        boolean flag = false;
        for(Double linha: mediaTemperaturas) {
            if (linha > media) {
                System.out.println((i + 1) + " - " + meses.get(i) + " ~ Temperatura: " + mediaTemperaturas.get(i));
                flag = true;
            }
            i++;
        }
        if(flag = false){
            System.out.println("Não existem meses com a temperatura acima da média semestral.");
        }
        return mediaTemperaturas;
    }

}


