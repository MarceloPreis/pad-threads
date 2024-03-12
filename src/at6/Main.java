package at6;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100]; // Exemplo de array
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(100); // Preenche o array com números aleatórios
        }

        int target = 42; // Número a ser buscado
        int nThreads = 10; // Número de threads
        int chunkSize = array.length / nThreads; // Tamanho do chunk para cada thread

        SearchArray searchArray = new SearchArray(array, target);
        Thread[] threads = new Thread[nThreads];

        for (int i = 0; i < nThreads; i++) {
            int start = i * chunkSize;
            int end = (i == nThreads - 1) ? array.length : start + chunkSize;
            threads[i] = new SearchThread(searchArray, start, end);
            threads[i].start();
        }

        // Espera todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verifica se o número foi encontrado
        if (searchArray.isStopSearch()) {
            System.out.println("O número " + target + " foi encontrado.");
        } else {
            System.out.println("O número " + target + " não foi encontrado.");
        }
    }
}
