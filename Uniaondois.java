import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
public class Uniaondois {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void main(String[] args) {
         int[] arrCrescente = generateSortedArray(100000);
        int[] arrDecrescente = generateReverseSortedArray(100000);
        int[] arrAleatorio1 = generateRandomArray(100000);
        int[] arrAleatorio2 = generateRandomArray(100000);
        int[] arrAleatorio3 = generateRandomArray(100000);

        measureTimeAndSort("Selection Sort (crescente)", arrCrescente.clone(), Uniaondois::selectionSort);
        measureTimeAndSort("Selection Sort (decrescente)", arrDecrescente.clone(), Uniaondois::selectionSort);
        measureTimeAndSort("Selection Sort (aleatório 1)", arrAleatorio1.clone(), Uniaondois::selectionSort);
        measureTimeAndSort("Selection Sort (aleatório 2)", arrAleatorio2.clone(), Uniaondois::selectionSort);
        measureTimeAndSort("Selection Sort (aleatório 3)", arrAleatorio3.clone(), Uniaondois::selectionSort);
        
        measureTimeAndSort("Insertion Sort (crescente)", arrCrescente.clone(), Uniaondois::insertionSort);
        measureTimeAndSort("Insertion Sort (decrescente)", arrDecrescente.clone(), Uniaondois::insertionSort);
        measureTimeAndSort("Insertion Sort (aleatório 1)", arrAleatorio1.clone(), Uniaondois::insertionSort);
        measureTimeAndSort("Insertion Sort (aleatório 2)", arrAleatorio2.clone(), Uniaondois::insertionSort);
        measureTimeAndSort("Insertion Sort (aleatório 3)", arrAleatorio3.clone(), Uniaondois::insertionSort);
		
        measureTimeAndSort("Bubble Sort (crescente)", arrCrescente.clone(), Uniaondois::bubbleSort);
        measureTimeAndSort("Bubble Sort (decrescente)", arrDecrescente.clone(), Uniaondois::bubbleSort);
        measureTimeAndSort("Bubble Sort (aleatório 1)", arrAleatorio1.clone(), Uniaondois::bubbleSort);
        measureTimeAndSort("Bubble Sort (aleatório 2)", arrAleatorio2.clone(), Uniaondois::bubbleSort);
        measureTimeAndSort("Bubble Sort (aleatório 3)", arrAleatorio3.clone(), Uniaondois::bubbleSort);
    }

    public static void measureTimeAndSort(String label, int[] arr, SortingAlgorithm sortingAlgorithm) {
        Instant start = Instant.now();
        sortingAlgorithm.sort(arr);
        Instant end = Instant.now();
        long timeElapsedMillis = Duration.between(start, end).toMillis();
        System.out.println(label + ": Tempo de execução = " + timeElapsedMillis + " ms");  
    }
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i - 1;
        }
        return arr;
    }
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10); 
        }
        return arr;
    }
    interface SortingAlgorithm {
        void sort(int[] arr);
    }
}
