package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

public class ListaEncadeadaTeste {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();
        lista.adicionaNoComeco(1);
        lista.adicionaNoComeco(2);
        lista.adicionaNoComeco(2);
        lista.adicionaNoComeco(2);
        lista.adicionaNoComeco(2);
        lista.adicionaNoComeco(3);
        lista.adicionaNoComeco(4);
        lista.adicionaNoFim(5);

        //lista.imprimirRecursivo();

        lista.imprimirRecursivoFinal();
        System.out.println(contagem(lista,2));
        System.out.println(lista.getNth(7));

    }
    public static int contagem(ListaEncadeadaSimples<Integer> lista, int a){
        int quantContagem = 0;
        No<Integer> atual = lista.getInicio();
        while (atual != null){
            if(atual.getElemento().equals(a)){
                quantContagem++;
            }
            atual = atual.getProximo();
        }
        return quantContagem;
    }
}
