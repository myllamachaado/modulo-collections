package modulo.trabalhando.com.collections;

import java.util.*;

public class ExemploMap {
    // Dada os modelos dos carros e seus respectivos consumos na estrada, faça
    // modelo = gol - consumo = 14,4 km/l
    // modelo = uno - consumo = 15,6 km/l
    // modelo = mobi - consumo = 16,1 km/l
    // modelo = hb20 - consumo = 14,5 km/l
    // modelo = kwid - consumo = 15,6 km/l
    public static void main(String[] args){

        // Map carrosPopulares = new HashMap<>(); -> Antes do java 5
        // Map<String, Double> carrosPopulares = new HashMap<>();
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares = Map.of("", 12.3);

        // Crie um dicinário que relacione os modelos e seus respectivos
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println("----------\nDicinário de carros: " + carrosPopulares);

        // Substitua o consumo do gol por 15,2 km
        carrosPopulares.put("gol", 15.2);
        System.out.println("----------\nDicinário de carros com modelo gol atualizado: " + carrosPopulares);

        // Confira se o modelo tucson está no dicionário
        System.out.println("----------\nO carro tuscon está na lista? " + carrosPopulares.containsKey("tucson"));

        // Exiba o consumo do uno
        System.out.println("----------\nO consumo do carro uno é: " + carrosPopulares.get("uno"));

        // Exiba o terceiro modelo adicionado

        // Exiba os modelos
        System.out.println("----------\nLista de modelos: ");
        exibeTabelasCarros(carrosPopulares);

        //Exiba os consumos dos carros
        System.out.println("----------\nLista de consumo: ");
        exibeConsumosCarros(carrosPopulares);

        // Exiba o modelo mais econômico e seu consumo
        System.out.println("----------\nCarro mais eficiente: ");
        buscaModeloMaisEficiente(carrosPopulares);

        // Exiba o modelo menos econômico e o consumo
        System.out.println("----------\nCarro menos eficiente: ");
        buscaModeloMenosEficiente(carrosPopulares);

        // Exiba a soma dos consumos
        System.out.println("----------\nA soma dos consumos é: " + retornaSomaConsumo(carrosPopulares));

        // Exiba a média dos consumos
        System.out.println("----------\nA média dos consumos é: " + retornaMediaConsumo(retornaSomaConsumo(carrosPopulares), carrosPopulares.size()));

        // Remova os carros com consumo iguais a 15,6
        removeCarro(carrosPopulares, 15.6);
        System.out.println("----------\nRemova os carros com consumo igual a 15,6: ");
        exibeTabelasCarros(carrosPopulares);

        // Exiba os carros na ordem em que foram informados
        LinkedHashMap<String, Double> carrosPopularesHashMap = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println("----------\nDicinário de carros em ordem natural de inserção: ");
        exibeTabelasCarrosLinkedHashMap(carrosPopularesHashMap);

        // Exiba o dicionário ordenado pelo modelo
        TreeMap<String, Double> carrosPopularesTreeMap = new TreeMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println("----------\nDicinário de carros ordenado pelo modelo: ");
        exibeTabelasCarrosTreeMap(carrosPopularesTreeMap);

        // Apague o conjunto de carros
        System.out.println("----------\nDicionários apagados: ");
        carrosPopularesTreeMap.clear();
        carrosPopularesHashMap.clear();
        carrosPopulares.clear();
        System.out.println("TreeMap: " + carrosPopularesTreeMap);
        System.out.println("HashMap: " + carrosPopularesHashMap);
        System.out.println("Map: " + carrosPopulares);

        // Confira se os dicionários estão vazios
        System.out.println("----------\nConfira se os dicionários estão apagados: ");
        System.out.println("TreeMap está vazio? " + carrosPopularesTreeMap.isEmpty());
        System.out.println("HashMap está vazio? " + carrosPopularesHashMap.isEmpty());
        System.out.println("Map está vazio? " + carrosPopulares.isEmpty());


    }

    public static void exibeTabelasCarros(Map<String, Double> listaCarros){
        for(String key: listaCarros.keySet()){
            System.out.println("Modelo: " + key + " | Consumo: " + listaCarros.get(key));
        }
    }

    public static void exibeTabelasCarrosLinkedHashMap(LinkedHashMap<String, Double> listaCarros){
        for(String key: listaCarros.keySet()){
            System.out.println("Modelo: " + key + " | Consumo: " + listaCarros.get(key));
        }
    }

    public static void exibeTabelasCarrosTreeMap(TreeMap<String, Double> listaCarros){
        for(String key: listaCarros.keySet()){
            System.out.println("Modelo: " + key + " | Consumo: " + listaCarros.get(key));
        }
    }

    public static void exibeConsumosCarros(Map<String, Double> listaCarros){
        for(String key: listaCarros.keySet()){
            System.out.println("Consumo: " + listaCarros.get(key));
        }
    }

    public static void buscaModeloMaisEficiente(Map<String, Double> carrosPopulares){
            Double consumoEficiente = Collections.max(carrosPopulares.values());
            String modeloEficiente =  "";
            Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

            for(Map.Entry<String, Double> entry: entries){
                if(entry.getValue().equals(consumoEficiente)){
                    modeloEficiente = entry.getKey();
                    System.out.println("Modelo mais eficiente: " + modeloEficiente + " | Consumo: " +  consumoEficiente);
                }
            }
    }

    public static void buscaModeloMenosEficiente(Map<String, Double> carrosPopulares){
        Double consumoEficiente = Collections.min(carrosPopulares.values());
        String modeloEficiente =  "";
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        for(Map.Entry<String, Double> entry: entries){
            if(entry.getValue().equals(consumoEficiente)){
                modeloEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloEficiente + " | Consumo: " +  consumoEficiente);
            }
        }
    }

    public static Double retornaSomaConsumo(Map<String, Double> carrosPopulares){
        Double somaConsumo = Collections.min(carrosPopulares.values());
        for(String key: carrosPopulares.keySet()){
            somaConsumo += carrosPopulares.get(key);
        }
        return somaConsumo;
    }

    public static Double retornaMediaConsumo(Double soma, int tam){
        return soma/tam;
    }

    public static void removeCarro(Map<String, Double> carrosPopulares, Double val){
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(val)){
                iterator.remove();
            }
        }
    }

}
