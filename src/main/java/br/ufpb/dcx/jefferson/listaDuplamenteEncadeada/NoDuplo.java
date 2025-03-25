package br.ufpb.dcx.jefferson.listaDuplamenteEncadeada;

public class NoDuplo<T>{
    private T elemento;
    private NoDuplo<T> anterior;
    private NoDuplo<T> proximo;

    public NoDuplo (T elemento){
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public NoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return this.elemento.toString();
    }
}
