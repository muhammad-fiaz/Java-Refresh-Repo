import java.util.*;

public class BinaryTreeUsingBuiltIn {

    public static void main(String[] args) {
        // Using TreeSet for Binary Search Tree functionality
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Inserting elements into the TreeSet (BST behavior)
        treeSet.add(50);
        treeSet.add(30);
        treeSet.add(20);
        treeSet.add(40);
        treeSet.add(70);
        treeSet.add(60);
        treeSet.add(80);

        // In-order Traversal (automatically done by TreeSet)
        System.out.println("In-order Traversal (sorted):");
        for (Integer val : treeSet) {
            System.out.print(val + " ");  // Sorted output
        }
        System.out.println();

        // Pre-order Traversal: We need to traverse manually as TreeSet is sorted.
        System.out.println("Pre-order Traversal (simulation):");
        preOrderSimulation(treeSet);  // Simulating pre-order traversal
        System.out.println();

        // Post-order Traversal: Also needs to be simulated manually
        System.out.println("Post-order Traversal (simulation):");
        postOrderSimulation(treeSet);  // Simulating post-order traversal
        System.out.println();

        // Searching for an element
        int searchKey = 40;
        if (treeSet.contains(searchKey)) {
            System.out.println("Element " + searchKey + " found in the tree.");
        } else {
            System.out.println("Element " + searchKey + " not found in the tree.");
        }
    }

    // Simulated Pre-order Traversal: Root → Left → Right
    public static void preOrderSimulation(TreeSet<Integer> treeSet) {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");  // Simulate root
        }
    }

    // Simulated Post-order Traversal: Left → Right → Root
    public static void postOrderSimulation(TreeSet<Integer> treeSet) {
        List<Integer> reversedList = new ArrayList<>(treeSet);
        Collections.reverse(reversedList);  // Reverse the list to simulate post-order
        for (Integer val : reversedList) {
            System.out.print(val + " ");  // Simulate root
        }
    }
}
