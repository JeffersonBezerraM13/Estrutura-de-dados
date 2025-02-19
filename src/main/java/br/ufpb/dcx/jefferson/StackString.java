package br.ufpb.dcx.jefferson;

import br.ufpb.dcx.std.StdIn;
import br.ufpb.dcx.std.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackString implements Iterator<String>{
    //Conjunto dinâmico = quantidade de dados guardados muda com o tempo
    //Last in, first out - lifo
    //(ultimo a entrar, primeiro a sair)
    private static final int TAMANHO = 8;

    private String [] s; //s de stack
    private int topo;

    public StackString(){
        this.s = new String [TAMANHO];
        this.topo = 0;
    }

    public boolean vazio(){
        return topo == 0; //true se o topo for igual a 0
    }

    public void empilhar(String str){ //empiljar sem veririficar o tamanho
        this.s[topo] = str;
        topo++;
    }
    public int size(){
        return topo;
    }
    String desempilhar(){
        if(this.topo == 0){
            throw new NoSuchElementException();
        }

        topo--; //decrementoo array para pegar o anterior
        String item = this.s[topo-1]; //guardo o item numa variavel temporaria
        this.s[topo] = null; //idico o lugar do array do item para null
        return item; //retorno o item guardado
    }
    private void redimensionar(int novoTamanho){
        assert novoTamanho >= topo;

        String [] novoArray = new String [novoTamanho];
        for(int i=0; i<novoArray.length;i++){
            novoArray[i] = s[i];
        }
        this.s = novoArray;
    }
    public void empilharRedimensionar(String novoStr){//push do slide
        if(topo == s.length){
            redimensionar(s.length*2);
        }
        this.s[topo] = novoStr;
        topo++;

    }

    public String pop(){
        if(vazio()){
            throw new NoSuchElementException();
        }
        String item = s[topo - 1];
        s[topo - 1] = null;
        topo--;
        //caso não esteja usando o array todo, redimensionar para um menor
        if(topo > 0 && topo == (s.length/4)){
            redimensionar(s.length/2);
        }
        return item;
    }
    public Iterator<String> iterator(){
        return new ReverseArrayIterator();
    }
    public class ReverseArrayIterator implements Iterator<String>{//classe aninhada
        private int i;

        public ReverseArrayIterator(){
            this.i = topo-1;
        }
        public boolean hasNext(){
            return i>=0;
        }
        public String next(){
            if(!hasNext()) throw new NoSuchElementException();
            return s[i--];
        }
    }
    @Override
    public boolean hasNext() {
        if(s[topo] != null){
            return true;
        } else return false;
    }

    @Override
    public String next() {
        return s[topo+1];
    }
    public static void main(String[]args){
        StackString stack = new StackString(); //pilha
        while(!StdIn.isEmpty()){ //enquanto tiver String na entrada do terminal V
            String item = StdIn.readString(); //essa variavel guardara o string.
            if(!item.equals("-")){ // se o string da variavel for diferente de "-"...
                stack.empilharRedimensionar(item); //guarde a variavel (o string) na pilha
            } else if (!stack.vazio()) { //se caso a pilha esteja não vazia...
                StdOut.print(stack.pop()+" "); //print cada string com o "Pop" e um espaço ( ).
            }
            //Explicação: Pilha é lifo (first in last out)
            //ou seja, se eu colocar um nome e tira ele esse mesmo nome saíra
            // se eu botar dois nome (Jefferson e Isabela) e da um "Pop" saíra apenas isabela (foi o ultimo nome a ser colocado)
            // entrada do terminal "Jeffeson Isabela Davi DaviFrancisco - - - Eduardo"
            // a saída deverá ser "Jefferson Eduardo"
        }
        StdOut.println("(" + stack.size() + " sobraram na pilha)"); // no final diga quantos str sobraram na pilha
    }
}
