package br.ufpb.dcx.jefferson;

public class BuscaSequencialMain {
    public static void main(String[] args) {
        //criação do array simples para testar os algoritmos
        int[] inteiros = new int[10];
        for (int i = 0; i < inteiros.length; i++) inteiros[i] += i + 1;
        for (int i = 0; i < inteiros.length; i++) System.out.println("indx:" + i + " -> " + inteiros[i]);
        //Usando a busca Sequancial
        StdOut.println(buscaSequencial(inteiros, 8));
        //Usando a busca binária
        StdOut.println(buscaBinária(inteiros, 8));
        //Usando a busca binária recursiva
        StdOut.println(buscaBinariaRecuriva(inteiros,8,0,inteiros.length));

    }
    //Slide "pesquisa em memória" página 5-6
    public static int buscaSequencial(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                return i;
            }
        }
        return (-1);
    }
    //Slide "pesquisa em memória" página 9-10
    public static int buscaBinária(int [] array, int inteiroProcurado){
        //teria que anteriormente acontecer um sort() no array
        int tamMax = array.length;
        int tamMin = 0;
        while(tamMin <= tamMax){
            int piso = (tamMax - tamMin)/2;
            int meio = tamMin+piso;
            if(inteiroProcurado < array[meio]){
                tamMax = meio - 1;
            } else if (inteiroProcurado > array[meio]){
                tamMin = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }
    //Slide "pesquisa em memória" página 15
    public static int buscaBinariaRecuriva(int [] array, int inteiroProcurado, int tamMin, int tamMax){
        //Mais fácil entender a anterior para depois enteder esse
        //Teria que rolar um .sort() no array
        if(tamMin <= tamMax){
            int meio = tamMin + (tamMax - tamMin)/2;
            if(inteiroProcurado < array[meio]){
                return buscaBinariaRecuriva(array, inteiroProcurado, tamMin, meio - 1);
            } else if (inteiroProcurado > array[meio]) {
                return buscaBinariaRecuriva(array, inteiroProcurado, meio + 1, tamMax);
            } else {
                return meio;
            }
        } else {
            return -1;
        }
    }
    //Mínimo e máximo
    //Slide "pesquisa em memória" página 17 - 18
    public static int minimo(int [] array){
        int min = array[0];
        for(int i=1; i<array.length; i++){
            if(min > array[i]) min = array[i];
        }
        return min;
    }
    //Slide "pesquisa em memória" página 19 - 20
    public static int maximo(int [] array){
        int max = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] > max) max = array[i];
        }
        return max;
    }
}
