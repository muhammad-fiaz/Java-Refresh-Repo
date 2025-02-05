import java.util.*;

public class SearchingExamples {

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        int target = 40;

        // Binary Search (using Arrays.binarySearch)
        System.out.println("Binary Search (Built-in):");
        int result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);

        // Linear Search (using List.indexOf)
        System.out.println("\nLinear Search (Built-in):");
        result = linearSearch(arr, target);
        System.out.println("Element found at index: " + result);

        // HashSet Search (Built-in)
        System.out.println("\nHash-based Search (Built-in using HashSet):");
        result = hashSetSearch(arr, target);
        System.out.println("Element found at index: " + result);

        // Existence Search (using contains method in ArrayList and HashSet)
        System.out.println("\nExistence Search (Built-in with contains()):");
        boolean exists = existenceSearch(arr, target);
        System.out.println("Element exists: " + exists);

        // Search in Sorted Array using Binary Search
        System.out.println("\nSearch in Sorted Array (using Binary Search):");
        Arrays.sort(arr); // Ensure sorted array for binary search
        result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);

        // TreeSet Search (Built-in)
        System.out.println("\nTreeSet Search (Built-in using TreeSet):");
        result = treeSetSearch(arr, target);
        System.out.println("Element found at index: " + result);

        // Search for first occurrence in List
        System.out.println("\nFirst Occurrence Search in List:");
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 20, 30, 40));
        result = firstOccurrenceSearch(list, target);
        System.out.println("First occurrence of " + target + " at index: " + result);
    }

    // ===================== Binary Search (Built-in) =====================
    public static int binarySearch(int[] arr, int target) {
        int result = Arrays.binarySearch(arr, target);
        return result >= 0 ? result : -1; // If not found, return -1
    }

    // ===================== Linear Search (Built-in) =====================
    public static int linearSearch(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list.indexOf(target); // Returns index of target, or -1 if not found
    }

    // ===================== HashSet Search (Built-in) =====================
    public static int hashSetSearch(int[] arr, int target) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : arr) {
            hashSet.add(num);
        }
        if (hashSet.contains(target)) {
            return Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)).indexOf(target);
        }
        return -1; // If not found
    }

    // ===================== Existence Search (Built-in) =====================
    public static boolean existenceSearch(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list.contains(target); // Returns true if element exists, otherwise false
    }

    // ===================== TreeSet Search (Built-in) =====================
    public static int treeSetSearch(int[] arr, int target) {
        Set<Integer> treeSet = new TreeSet<>();
        for (int num : arr) {
            treeSet.add(num);
        }
        // TreeSet doesn't provide index, but you can check if it contains the element
        if (treeSet.contains(target)) {
            return 1; // Simulating search success by returning 1
        }
        return -1; // If not found
    }

    // ===================== First Occurrence Search =====================
    public static int firstOccurrenceSearch(List<Integer> list, int target) {
        return list.indexOf(target); // Finds the first occurrence index
    }
}
