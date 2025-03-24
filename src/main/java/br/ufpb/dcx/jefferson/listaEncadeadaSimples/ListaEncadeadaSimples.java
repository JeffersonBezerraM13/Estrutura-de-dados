package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

public class ListaEncadeadaSimples<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public void adicionaNoComeco(T elemento){
        No<T> noAntigo = this.inicio;
        this.inicio = new No<>(elemento);
        if(noAntigo == null && this.tamanho == 0){
           this.ultimo = this.inicio;
        } else {
            this.inicio.setProximo(noAntigo);
        }
        this.tamanho++;
    }

    public void adicionaNoFim(T elemento){
        No<T> noAntigo = this.ultimo;
        this.ultimo = new No<>(elemento);
        if(noAntigo == null && this.tamanho == 0){
            this.inicio = this.ultimo;
        } else {
            noAntigo.setProximo(this.ultimo);
        }
        this.tamanho++;
    }

    public No<T> getElemento(T elemento){
        No<T> noAntigo = this.inicio;
        while(noAntigo != null && !noAntigo.getElemento().equals(elemento)){
            noAntigo = noAntigo.getProximo();
        }
        if(noAntigo == null){
            return null;
        }
        return noAntigo;
    }


    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
//        No<T> atual = this.inicio;
//        str.append(atual.getElemento()).append(",");
//        while(atual.getProximo() != null){
//            atual = atual.getProximo();
//            str.append(atual.getElemento()).append(",");
//        }
        No<T> atual = this.inicio;
        for(int i = 0; i < this.tamanho - 1; i++){
            str.append(atual.getElemento().toString()).append(",");
            atual = atual.getProximo();
        }
        str.append(atual.getElemento().toString()).append("]");
        return str.toString();
    }
}
