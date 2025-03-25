package br.ufpb.dcx.jefferson.listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeadaTeste {
    public static void main(String [] args){
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);

        lista.adicionarNoFinal(5);


        System.out.println(lista);
    }
}
