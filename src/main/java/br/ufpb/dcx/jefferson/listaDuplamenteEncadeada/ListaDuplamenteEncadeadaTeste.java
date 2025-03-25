package br.ufpb.dcx.jefferson.listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeadaTeste {
    public static void main(String [] args){
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.adicionarNoFinal(1);
        lista.adicionarNoFinal(2);
        lista.adicionarNoFinal(3);
        lista.adicionarNoFinal(4);


        System.out.println(lista);
    }
}
