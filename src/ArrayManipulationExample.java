
public class ArrayManipulationExample {
    public static void main(String[] args) {
        // ===================== 1. Array Initialization =====================
        int[] intArray = new int[5]; // Declaring an array of integers
        intArray[0] = 10; // Assigning values to array elements
        intArray[1] = 20;
        intArray[2] = 30;
        intArray[3] = 40;
        intArray[4] = 50;

        System.out.println("Initial Array:");
        for (int i : intArray) {
            System.out.print(i + " ");  // Output: 10 20 30 40 50
        }
        System.out.println();

        // ===================== 2. Array Access and Update =====================
        System.out.println("Element at index 2: " + intArray[2]);  // Output: 30

        // Update value at index 2
        intArray[2] = 100;
        System.out.println("Updated Element at index 2: " + intArray[2]);  // Output: 100

        // ===================== 3. Array Length =====================
        System.out.println("Array Length: " + intArray.length);  // Output: 5

        // ===================== 4. Multi-dimensional Array =====================
        int[][] multiArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Multi-dimensional Array:");
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print(multiArray[i][j] + " ");  // Output: 1 2 3 4 5 6 7 8 9
            }
            System.out.println();
        }

        // ===================== 5. Searching for an Element =====================
        int searchElement = 100;
        boolean found = false;
        for (int i : intArray) {
            if (i == searchElement) {
                found = true;
                break;
            }
        }
        System.out.println("Is " + searchElement + " found in the array? " + found);  // Output: true

        // ===================== 6. Copying Arrays =====================
        int[] copiedArray = new int[intArray.length];
        System.arraycopy(intArray, 0, copiedArray, 0, intArray.length);  // Copying array

        System.out.println("Copied Array:");
        for (int i : copiedArray) {
            System.out.print(i + " ");  // Output: 10 20 100 40 50
        }
        System.out.println();

        // ===================== 7. Sorting Arrays =====================
        java.util.Arrays.sort(intArray);  // Sorting the array in ascending order
        System.out.println("Sorted Array:");
        for (int i : intArray) {
            System.out.print(i + " ");  // Output: 10 20 40 50 100
        }
        System.out.println();

        // ===================== 8. Reverse Array =====================
        System.out.println("Reversed Array:");
        for (int i = intArray.length - 1; i >= 0; i--) {
            System.out.print(intArray[i] + " ");  // Output: 100 50 40 20 10
        }
        System.out.println();

        // ===================== 9. Array with Default Values =====================
        String[] strArray = new String[3];  // String array with default values (null)
        System.out.println("String Array with default values:");
        for (String s : strArray) {
            System.out.print(s + " ");  // Output: null null null
        }
        System.out.println();

        // ===================== 10. Array List Manipulation =====================
        // Using ArrayList (dynamic array) for more flexible array manipulations
        java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<>();
        arrayList.add(10);  // Adding elements to ArrayList
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList Elements:");
        for (int i : arrayList) {
            System.out.print(i + " ");  // Output: 10 20 30
        }
        System.out.println();

        // Remove element from ArrayList
        arrayList.remove(Integer.valueOf(20));  // Removes the first occurrence of 20
        System.out.println("ArrayList after removal:");
        for (int i : arrayList) {
            System.out.print(i + " ");  // Output: 10 30
        }
        System.out.println();

        // ===================== 11. 2D Array Traversing =====================
        System.out.println("Traversing a 2D array:");
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print(multiArray[i][j] + " ");  // Output: 1 2 3 4 5 6 7 8 9
            }
            System.out.println();
        }

        // ===================== 12. Flattening 2D Array =====================
        System.out.println("Flattening a 2D array into a 1D array:");
        int[] flatArray = new int[multiArray.length * multiArray[0].length];
        int index = 0;
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                flatArray[index++] = multiArray[i][j];
            }
        }
        for (int i : flatArray) {
            System.out.print(i + " ");  // Output: 1 2 3 4 5 6 7 8 9
        }
        System.out.println();
    }
}

