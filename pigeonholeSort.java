public static void pigeonholeSort(int[] array) {
    // Array nulo ou com tamanho 0/1: ORDENADO
    if (
        (array == null) || 
        (array.length == 0) || 
        (array.length == 1)
    ) return;

    // Descobrir Min e Max
    int min = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
        if (array[i] < min) min = array[i];
        if (array[i] > max) max = array[i];
    }

    // Array auxiliar
    int tamanhoCaixas = (max - min) + 1;
    int[] caixas = new int[tamanhoCaixas]; // armazena quantos pombos tem em cada caixa

    // Contar pombos nas caixas
    int numAtual, indiceCaixa;
    
    for (int i = 0; i < array.length; i++) {
        numAtual = array[i];
        indiceCaixa = numAtual - min;

        caixas[indiceCaixa]++; // +1 pombo
    }

    // Ordenar o array
    int indiceOriginal = 0;
    int valor;

    for (int i = 0; i < tamanhoCaixas; i++) {
        while(caixas[i] > 0) {
            valor = i + min;
            array[indiceOriginal] = valor;
            
            indiceOriginal++;
            caixas[i]--;
        }
    }
}