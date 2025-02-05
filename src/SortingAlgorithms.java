import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr4 = {5, 2, 9, 1, 5, 6};
        int[] arr5 = {12, 11, 13, 5, 6, 7};

        // Quick Sort
        System.out.println("Quick Sort:");
        quickSort(arr1, 0, arr1.length - 1);
        printArray(arr1);

        // Merge Sort
        System.out.println("\nMerge Sort:");
        mergeSort(arr2, 0, arr2.length - 1);
        printArray(arr2);

        // Heap Sort
        System.out.println("\nHeap Sort:");
        heapSort(arr3);
        printArray(arr3);

        // Bubble Sort
        System.out.println("\nBubble Sort:");
        bubbleSort(arr4);
        printArray(arr4);

        // Insertion Sort
        System.out.println("\nInsertion Sort:");
        insertionSort(arr5);
        printArray(arr5);
    }

    // ===================== Quick Sort =====================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pivot
            quickSort(arr, pi + 1, high); // After pivot
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // ===================== Merge Sort =====================
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m); // Left half
            mergeSort(arr, m + 1, r); // Right half

            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // ===================== Heap Sort =====================
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // ===================== Bubble Sort =====================
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ===================== Insertion Sort =====================
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

    // ===================== Print Array =====================
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
