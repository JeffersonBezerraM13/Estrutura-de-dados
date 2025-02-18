package pilha01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A classe <tt>Stack</tt> representa uma pilha de itens genéricos que segue a política LIFO.
 * Ela suporta operações de <em>push</em> e <em>pop</em>, além de métodos para verificar o item no topo,
 * testar se a pilha está vazia e iterar sobre os itens na ordem LIFO.
 * <p>
 * Esta implementação usa uma lista simplesmente encadeada com uma classe aninhada estática para os nós.
 * As operações <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em> e <em>is-empty</em>
 * têm tempo constante no pior caso.
 * <p>
 * Para documentação adicional, consulte <a href="http://algs4.cs.princeton.edu/13stacks">Seção 1.3</a>
 * de <i>Algorithms, 4th Edition</i> por Robert Sedgewick e Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 *
 * @param <Item> o tipo genérico de um item nesta pilha
 */
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first; // topo da pilha
    private int n; // tamanho da pilha

    // classe aninhada estática para os nós da lista encadeada
    private static class Node<Item> {
        private Item item; // item armazenado no nó
        private Node<Item> next; // referência para o próximo nó
    }

    /**
     * Inicializa uma pilha vazia.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Retorna true se a pilha estiver vazia.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Retorna o número de itens na pilha.
     */
    public int size() {
        return n;
    }

    /**
     * Adiciona o item à pilha.
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Remove e retorna o item mais recentemente adicionado à pilha.
     * Lança uma exceção se a pilha estiver vazia.
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; // salva o item para retornar
        first = first.next; // remove o primeiro nó
        n--;
        return item; // retorna o item salvo
    }

    /**
     * Retorna (mas não remove) o item mais recentemente adicionado à pilha.
     * Lança uma exceção se a pilha estiver vazia.
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Retorna uma representação em string da pilha.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Retorna um iterador que itera sobre os itens na pilha em ordem LIFO.
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // classe interna para o iterador
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Testes unitários para o tipo de dados <tt>Stack</tt>.
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
