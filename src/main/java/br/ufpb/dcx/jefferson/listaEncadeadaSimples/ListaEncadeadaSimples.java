package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

public class ListaEncadeadaSimples<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private No<T> atual;
    private int tamanho;

    public void adicionaNoComeco(T elemento){
        No<T> novoNo = new No<>(elemento);
        if(this.tamanho == 0){
            this.cabeca = novoNo;
        } else {
            this.cauda.setProximo(novoNo);
        }
        this.cauda = novoNo;
        this.tamanho++;
    }

    public void adicionaNoFim(T elemento){
        No<T> nonoNo = this.cauda;
        this.cauda = new No<>(elemento);
        if(this.tamanho == 0){
            this.cabeca = this.cauda;
        } else {
            nonoNo.setProximo(this.cauda);
        }
        this.tamanho++;
    }

    public No<T> getNoAPartirDoElemento(T elemento){
        No<T> atual = this.cabeca;
        while (atual != null){
            if(atual.getElemento().equals(elemento))
                return atual;
            atual = atual.getProximo();
        }
        return null;

//        this.atual = this.cabeca;
//        while(this.atual != null && !this.atual.getElemento().equals(elemento)){
//            this.atual = this.atual.getProximo();
//        }
//        if(this.atual == null){
//            return null;
//        }
//        return this.atual;
    }

    public T retirarDoComeco(){
        if(this.tamanho == 0){
            return null;
        }
        No<T> atual = this.cabeca;
        T dado = atual.getElemento();
        this.cabeca = this.cabeca.getProximo();
        this.tamanho--;
        return dado;

//        if(this.tamanho == 0  && this.cabeca == null){
//            return null;
//        }
//        T dado = this.cabeca.getElemento();
//        this.cabeca = this.cabeca.getProximo(); //interando
//        this.tamanho--;
//        return dado;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void imprimirRecursivo(){
        imprimirRecursivo(this.cabeca);
    }
    public void imprimirRecursivo(No<T> atual){
        if(atual == null){
            return;
        }
        System.out.println(atual.getElemento());
        imprimirRecursivo(atual.getProximo());
    }

    public void imprimirRecursivoFinal(){
        imprimirRecursivoFinal(this.cabeca);
    }
    public void imprimirRecursivoFinal(No<T> atual){
        if(atual == null) {
            return;
        }
        imprimirRecursivoFinal(atual.getProximo());
        System.out.println(atual.getElemento());
    }

    public No<T> getNth(int index) throws RuntimeException{
        No<T> atual = this.cabeca;
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

    public No<T> getCabeca() {
        return cabeca;
    }

    public void setCabeca(No<T> cabeca) {
        this.cabeca = cabeca;
    }

    public No<T> getCauda() {
        return cauda;
    }

    public void setCauda(No<T> cauda) {
        this.cauda = cauda;
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
//        No<T> atual = this.cabeca;
//        str.append(atual.getNoAPartirDoElemento()).append(",");
//        while(atual.getProximo() != null){
//            atual = atual.getProximo();
//            str.append(atual.getNoAPartirDoElemento()).append(",");
//        }
        No<T> atual = this.cabeca;
        for(int i = 0; i < this.tamanho - 1; i++){
            str.append(atual.getElemento().toString()).append(",");
            atual = atual.getProximo();
        }
        str.append(atual.getElemento().toString()).append("]");
        return str.toString();
    }
}
