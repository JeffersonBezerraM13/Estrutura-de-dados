package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

public class ListaEncadeadaTeste {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();
        lista.adicionaNoComeco(1);
        lista.adicionaNoComeco(2);
        lista.adicionaNoComeco(3);
        lista.adicionaNoComeco(4);

        System.out.println(lista);
    }
}
