package br.ufpb.dcx.jefferson;

public class BuscaSequencialMain {
    public static void main(String[] args) {
        //criação do array simples para testar os algoritmos
        int[] inteiros = new int[1000];
        for (int i = 0; i < inteiros.length; i++) inteiros[i] += i + 1;
        for (int i = 0; i < inteiros.length; i++) System.out.println("indx:" + i + " -> " + inteiros[i]);
        //Usando a busca Sequancial
        System.out.println(buscaSequencial(inteiros, 8));
        System.out.println(buscaBinária(inteiros, 8));
        //Usando a busca binária

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
        int tamMax = array.length;
        int tamMin = 0;
        while(tamMin <= tamMax){
            int piso = (tamMax - tamMin)/2;
            int mid = tamMin+piso;
            if(inteiroProcurado < array[mid]){
                tamMax = mid - 1;
            } else if (inteiroProcurado > array[mid]){
                tamMin = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
