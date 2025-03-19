package br.ufpb.dcx.jefferson.listaEncadeadaSimples;

// Classe que representa a lista encadeada simples
class ListaEncadeada {
    private No cabeca; // Primeiro nó da lista
    private No cauda;  // Último nó da lista
    private int tamanho; // Número de elementos na lista
    static class No {
        int dado;       // Valor armazenado no nó
        No proximo;     // Referência para o próximo nó

        // Construtor
        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
    // Construtor
    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    // Método para inserir um nó no início da lista
    public void inserirNoComeco(int dado) {
        No temporario = cabeca;
        cabeca = new No(dado); //vai substituir a cabeça antiga (nova cabeça)
        cabeca.proximo = null;
        if(temporario == null){ //se a lista estiver vazia
            cauda = cabeca; // a cauda é igual a cabeça
        } else {
            cabeca.proximo = temporario; //a nova cabeça vai guardar o endereço da cabeça antiga (no temporario)
        }
        tamanho++;
    }

    // Método para inserir um nó no fim da lista
    public void inserirNoFim(int dado) {
        No temporario = cauda;
        cauda = new No(dado);
        cauda.proximo = null;
        if(temporario == null){
            cauda = cabeca;
        } else {
            temporario.proximo = cauda;
        }
        tamanho++; // Incrementa o tamanho da lista
    }

    // Método para buscar um nó com um valor específico
    public No buscar(int dado) {
        No atual = cabeca; // Começa pela cabeça
        while (atual != null && atual.dado != dado) {
            atual = atual.proximo; // Avança para o próximo nó
        }
        return atual;
    }

    // Método para retirar o nó do início da lista
    public int retirarDoComeco() throws Exception {
        if (cabeca == null){
            throw new Exception("msg");
        }
        int dado = cabeca.dado;
        tamanho--;
        cabeca = cabeca.proximo;
        if(cabeca == null){
            cauda = null;
        }
        return dado;
    }

    // Método para retirar o nó do fim da lista
    public void retirarDoFim() {
        if (cauda == null) { // Se a lista estiver vazia
            System.out.println("Lista vazia! Nada para retirar.");
            return;
        }
        if (cabeca == cauda) { // Se houver apenas um nó na lista
            cabeca = null;
            cauda = null;
        } else {
            No atual = cabeca;
            while (atual.proximo != cauda) { // Encontra o nó anterior à cauda
                atual = atual.proximo;
            }
            atual.proximo = null; // Remove a referência para a cauda
            cauda = atual; // O nó anterior agora é a cauda
        }
        tamanho--; // Decrementa o tamanho da lista
    }

    // Método para exibir a lista
    public void exibir() {
        No atual = cabeca; // Começa pela cabeça
        while (atual != null) {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo; // Avança para o próximo nó
        }
        System.out.println("null"); // Indica o fim da lista
    }

    // Método para obter o tamanho da lista
    public int getTamanho() {
        return tamanho;
    }
    public static void main(String[] args) throws Exception {
        ListaEncadeada lista = new ListaEncadeada();

        // Inserindo elementos no início e no fim
        lista.inserirNoComeco(10);
        lista.inserirNoFim(20);
        lista.inserirNoComeco(5);
        lista.inserirNoFim(30);

        // Exibindo a lista
        System.out.println("Lista após inserções:");
        lista.exibir(); // Saída esperada: 5 -> 10 -> 20 -> 30 -> null

        // Buscando elementos
        System.out.println("Buscar 20: " + lista.buscar(20)); // Saída esperada: true
        System.out.println("Buscar 15: " + lista.buscar(15)); // Saída esperada: false

        // Retirando elementos do início e do fim
        lista.retirarDoComeco();
        lista.retirarDoFim();

        // Exibindo a lista após remoções
        System.out.println("Lista após remoções:");
        lista.exibir(); // Saída esperada: 10 -> 20 -> null

        // Exibindo o tamanho da lista
        System.out.println("Tamanho da lista: " + lista.getTamanho()); // Saída esperada: 2
    }
}