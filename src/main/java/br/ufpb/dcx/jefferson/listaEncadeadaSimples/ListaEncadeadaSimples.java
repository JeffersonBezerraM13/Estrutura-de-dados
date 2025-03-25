package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

import br.ufpb.dcx.jefferson.listaDuplamenteEncadeada.NoDuplo;

public class ListaEncadeadaSimples<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private No<T> atual;
    private int tamanho;

    public void adicionaNoComeco(T elemento){
        No<T> novoNo = new No<>(elemento);
        if(this.tamanho == 0 && this.inicio == null){
            this.inicio = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo;
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
        this.atual = this.inicio;
        while(this.atual != null && !this.atual.getElemento().equals(elemento)){
            this.atual = this.atual.getProximo();
        }
        if(this.atual == null){
            return null;
        }
        return this.atual;
    }

    public T retirarDoComeco(){
        if(this.tamanho == 0  && this.inicio == null){
            return null;
        }
        T dado = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo(); //interando
        this.tamanho--;
        return dado;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void imprimirRecursivo(){
        imprimirRecursivo(this.inicio);
    }
    public void imprimirRecursivo(No<T> atual){
        if(atual == null){
            return;
        }
        System.out.println(atual.getElemento());
        imprimirRecursivo(atual.getProximo());
    }

    public void imprimirRecursivoFinal(){
        imprimirRecursivoFinal(this.inicio);
    }
    public void imprimirRecursivoFinal(No<T> atual){
        if(atual == null ) {
            return;
        }
        imprimirRecursivoFinal(atual.getProximo());
        System.out.println(atual.getElemento());
    }

    public No<T> getNth(int index) throws RuntimeException{
        No<T> atual = this.inicio;
        int cont = 1;
        while (atual != null){
            if(cont == index){
                return atual;
            } else {
                cont++;
            }
            atual = atual.getProximo();
        }
        throw new RuntimeException();
    }

    public No<T> getInicio() {
        return inicio;
    }

    public void setInicio(No<T> inicio) {
        this.inicio = inicio;
    }

    public No<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    public No<T> getAtual() {
        return atual;
    }

    public void setAtual(No<T> atual) {
        this.atual = atual;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
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
