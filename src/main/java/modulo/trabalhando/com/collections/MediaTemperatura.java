package modulo.trabalhando.com.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MediaTemperatura {
    // Faça um programa que receba a temperatura media  dos 6 primeiros meses do ano e armazene-os em um alista.
    // Após isso calcule a média semestral das temperaturas e mostre toda sas temperaturas acima dessa média e
    // o mês em que elas ocorreram (mostrar o mês por extenso)
    public static void main(String[] args) throws IOException {
        List<Double> mediaTemperaturas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String accStr;

        for(int i =0; i < 6; i++) {
            System.out.println("Insira a temperatura do mês 0" + (i+1) + ": ");
            String aux = br.readLine();
            mediaTemperaturas.add(Double.parseDouble(aux));
        }
        System.out.println("Lista de temperaturas: " + mediaTemperaturas);
        System.out.println("Asoma das temperaturas: " + somaMedias(mediaTemperaturas));
        System.out.println("A média semestral das temperaturas: " + mediaDasMedias(mediaTemperaturas));

        Double media = mediaDasMedias(mediaTemperaturas);
        System.out.println("Meses com a média maior que a média semestral: ");
        System.out.println(zeraValoresAbaixoMedia(mediaTemperaturas, media));


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

    public static List<Double> zeraValoresAbaixoMedia(List<Double> mediaTemperaturas, Double media){
        int i = 0;
        for(Double linha: mediaTemperaturas){
            if(linha < media){
                mediaTemperaturas.set(i, 0.0);
            }
            i++;
        }
        return mediaTemperaturas;
    }

}


