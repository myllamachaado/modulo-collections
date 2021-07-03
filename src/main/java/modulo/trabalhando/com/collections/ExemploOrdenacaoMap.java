package modulo.trabalhando.com.collections;

import java.util.*;

public class ExemploOrdenacaoMap {
    // Autor = Hawking, Stephen     - Livro = Uma breve hostória do tempo   - páginas = 256
    // Autor = Duhigg, Charles      - Livro = O poder do habito             - páginas = 408
    // Autor = Harari, Yuval Noah   - Livro = 21 lições para o século 21    - páginas = 432
    public static void main(String[] args){

        // Ordem aleatória:
        Map<String, Livro> listaLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve hostória do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do habito",  408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",  432));
        }};

        System.out.println("----------\nLista inserida em ordem aleatória: ");
        exibeMap(listaLivros);

        // Ordem de inserção:
        LinkedHashMap<String, Livro> listaLivrosLinkedHashMap = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve hostória do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do habito",  408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",  432));
        }};

        System.out.println("----------\nLista inserida em ordem de inserção: ");
        exibeLinkedHashMap(listaLivrosLinkedHashMap);

        // Ordem alfabética de autores
        TreeMap<String, Livro> listaLivrosTreeMap = new TreeMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve hostória do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do habito",  408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21",  432));
        }};

        System.out.println("----------\nLista inserida em ordem alfabética de autores: ");
        exibeTreeMap(listaLivrosTreeMap);

        // Ordem alfabética nomes dos livros
        Set<Map.Entry<String, Livro>> livroOrdemTitulo = new TreeSet<>(new ComparatorNome());
        livroOrdemTitulo.addAll(listaLivrosTreeMap.entrySet());
        System.out.println("----------\nLista inserida em ordem alfabética de livros: ");
        exibeTreeMapIterator(livroOrdemTitulo);

        // Ordenar por número de páginas
        Set<Map.Entry<String, Livro>> livroOrdemNumeroPaginas = new TreeSet<>(new ComparatorNumeroPaginas());
        livroOrdemNumeroPaginas.addAll(listaLivrosTreeMap.entrySet());
        System.out.println("----------\nLista inserida pela ordem do número de páginas dos livros: ");
        exibeTreeMapIterator(livroOrdemNumeroPaginas);

        // Ordenar por número de páginas
        compatarorLambda(listaLivrosTreeMap);
    }

    public static void exibeMap(Map<String, Livro> listaLivros){
        for(String key: listaLivros.keySet()){
            System.out.println("Autor: " + key + " | Chave: " + listaLivros.get(key));
        }
    }

    public static void exibeLinkedHashMap(LinkedHashMap<String, Livro> listaLivros){
        for(String key: listaLivros.keySet()){
            System.out.println("Modelo: " + key + " | Consumo: " + listaLivros.get(key));
        }
    }

    public static void exibeTreeMap(TreeMap<String, Livro> listaLivros){
        for(String key: listaLivros.keySet()){
            System.out.println("Modelo: " + key + " | Consumo: " + listaLivros.get(key));
        }
    }

    public static void exibeTreeMapIterator(Set<Map.Entry<String, Livro>> listaLivros){
        Iterator<Map.Entry<String, Livro>> iterator = listaLivros.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public static void compatarorReferenceMethod(TreeMap<String, Livro> listaLivros){
        // Ordenar por número de páginas
        Set<Map.Entry<String, Livro>> livroOrdemNumeroPaginas = new TreeSet<>(new Comparator<Map.Entry<String, Livro>>() {
            @Override
            public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
                return Integer.compare(l1.getValue().getNumPaginas(), l2.getValue().getNumPaginas());
            }
        });

        livroOrdemNumeroPaginas.addAll(listaLivros.entrySet());
        System.out.println("----------\nLista inserida pela ordem do número de páginas dos livros usando Reference Method: ");
        exibeTreeMapIterator(livroOrdemNumeroPaginas);
    }

    public static void compatarorLambda(TreeMap<String, Livro> listaLivros){
        // Ordenar por número de páginas
        Set<Map.Entry<String, Livro>> livroOrdemNumeroPaginas = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumPaginas()));

        livroOrdemNumeroPaginas.addAll(listaLivros.entrySet());
        System.out.println("----------\nLista inserida pela ordem do número de páginas dos livros usando expressões lambda: ");
        exibeTreeMapIterator(livroOrdemNumeroPaginas);
    }

}
