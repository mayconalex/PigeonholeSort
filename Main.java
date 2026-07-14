import java.util.Arrays;

public class Main {

    public static void pigeonholeSort(int[] array) {
        // Array nulo ou com tamanho 0/1: ORDENADO
        if (array == null || array.length <= 1) return;

        // Descobrir menor e maior valor
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        int[] caixas = new int[(max - min) + 1]; // armazena quantos pombos tem em cada caixa

        // Contar pombos nas caixas
        for (int i = 0; i < array.length; i++) {
            caixas[array[i] - min]++; // +1 pombo
        }

        int indiceOriginal = 0;
        
        // Ordenar o array
        for (int i = 0; i < caixas.length; i++) {
            while(caixas[i] > 0) {
                array[indiceOriginal++] = i + min;
                caixas[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Array de teste
        int[] arrayDeTeste = {8, 3, 2, 7, 4, 6, 8};

        System.out.println("=== TESTE PIGEONHOLE SORT ===");
        
        System.out.println("\nArray Original:");
        System.out.println(Arrays.toString(arrayDeTeste));

        // Chama o método para ordenar
        pigeonholeSort(arrayDeTeste);

        System.out.println("\nArray Ordenado:");
        System.out.println(Arrays.toString(arrayDeTeste));
    }
}