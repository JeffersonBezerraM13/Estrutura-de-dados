package br.ufpb.dcx.jefferson.listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> cabeca;
    private NoDuplo<T> cauda;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adicionar(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        if (this.tamanho == 0) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            this.cauda.setProximo(novoNo);
            novoNo.setAnterior(this.cauda);
            this.cauda = novoNo;
        }
        tamanho++;
    }

    // Adiciona um elemento no final da lista
    public void adicionarNoFinal(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        if (this.tamanho == 0) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.setAnterior(cauda);
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
        tamanho++;
    }

    // Adiciona um elemento em uma posição específica
    public void adicionarNaPosicao(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            adicionar(elemento);
        } else if (posicao == tamanho) {
            adicionarNoFinal(elemento);
        } else {
            NoDuplo<T> noAtual = obterNo(posicao);
            NoDuplo<T> noAnterior = noAtual.getAnterior();
            NoDuplo<T> novoNo = new NoDuplo<>(elemento);

            novoNo.setProximo(noAtual);
            novoNo.setAnterior(noAnterior);
            noAnterior.setProximo(novoNo);
            noAtual.setAnterior(novoNo);

            tamanho++;
        }
    }

    // Remove o primeiro elemento da lista
    public T removerDoInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia");
        }

        T dado = cabeca.getElemento();
        cabeca = cabeca.getProximo();

        if (cabeca != null) {
            cabeca.setAnterior(null);
        } else {
            cauda = null;
        }

        tamanho--;
        return dado;
    }

    // Remove o último elemento da lista
    public T removerDoFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia");
        }

        T dado = cauda.getElemento();
        cauda = cauda.getAnterior();

        if (cauda != null) {
            cauda.setProximo(null);
        } else {
            cabeca = null;
        }

        tamanho--;
        return dado;
    }

    // Remove um elemento de uma posição específica
    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            return removerDoInicio();
        } else if (posicao == tamanho - 1) {
            return removerDoFinal();
        } else {
            NoDuplo<T> noAtual = obterNo(posicao);
            NoDuplo<T> noAnterior = noAtual.getAnterior();
            NoDuplo<T> noProximo = noAtual.getProximo();

            noAnterior.setProximo(noProximo);
            noProximo.setAnterior(noAnterior);

            tamanho--;
            return noAtual.getElemento();
        }
    }

    // Obtém um nó em uma posição específica (método auxiliar)
    private NoDuplo<T> obterNo(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        NoDuplo<T> noAtual;

        // Decide se começa a busca pela cabeça ou pela cauda
        if (posicao < tamanho / 2) {
            noAtual = cabeca;
            for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.getProximo();
            }
        } else {
            noAtual = cauda;
            for (int i = tamanho - 1; i > posicao; i--) {
                noAtual = noAtual.getAnterior();
            }
        }

        return noAtual;
    }

    // Obtém o elemento em uma posição específica
    public T obter(int posicao) {
        return obterNo(posicao).getElemento();
    }

    // Limpa a lista
    public void limpar() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    // Verifica se a lista contém um elemento
    public boolean contem(T elemento) {
        NoDuplo<T> noAtual = cabeca;

        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                return true;
            }
            noAtual = noAtual.getProximo();
        }

        return false;
    }


    // Retorna a representação da lista como String
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        NoDuplo<T> noAtual = cabeca;

        while (noAtual != null) {
            sb.append(noAtual.getElemento());
            if (noAtual.getProximo() != null) {
                sb.append(", ");
            }
            noAtual = noAtual.getProximo();
        }

        sb.append("]");
        return sb.toString();
    }

    // Retorna a representação da lista como String em ordem reversa
    public String toStringReverso() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        NoDuplo<T> noAtual = cauda;

        while (noAtual != null) {
            sb.append(noAtual.getElemento());
            if (noAtual.getAnterior() != null) {
                sb.append(", ");
            }
            noAtual = noAtual.getAnterior();
        }

        sb.append("]");
        return sb.toString();
    }
}



// Limpa a lista