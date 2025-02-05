
import java.util.LinkedList;
import java.util.ListIterator;

public class SimplifyLinkedList {

    public static void main(String[] args) {
        // Singly Linked List Operations
        LinkedList<Integer> singlyLinkedList = new LinkedList<>();
        System.out.println("==== Singly Linked List ====");
        singlyLinkedList.add(10);
        singlyLinkedList.add(20);
        singlyLinkedList.add(30);
        singlyLinkedList.addFirst(5);
        printList(singlyLinkedList);

        singlyLinkedList.remove(Integer.valueOf(20));
        printList(singlyLinkedList);
        singlyLinkedList.add(25);
        singlyLinkedList.add(15);
        singlyLinkedList = mergeSort(singlyLinkedList);
        System.out.println("Sorted Singly Linked List:");
        printList(singlyLinkedList);

        // Delete element
        singlyLinkedList = deleteElement(singlyLinkedList, 30);
        System.out.println("After Deleting 30:");
        printList(singlyLinkedList);

        // Doubly Linked List Operations
        LinkedList<Integer> doublyLinkedList = new LinkedList<>();
        System.out.println("\n==== Doubly Linked List ====");
        doublyLinkedList.add(40);
        doublyLinkedList.add(50);
        doublyLinkedList.add(60);
        doublyLinkedList.addFirst(35);
        printList(doublyLinkedList);

        doublyLinkedList.remove(Integer.valueOf(50));
        printList(doublyLinkedList);
        doublyLinkedList.add(55);
        doublyLinkedList = mergeSort(doublyLinkedList);
        System.out.println("Sorted Doubly Linked List:");
        printList(doublyLinkedList);

        // Delete element
        doublyLinkedList = deleteElement(doublyLinkedList, 40);
        System.out.println("After Deleting 40:");
        printList(doublyLinkedList);

        // Circular Linked List Simulation
        System.out.println("\n==== Circular Linked List Simulation ====");
        LinkedList<Integer> circularLinkedList = new LinkedList<>();
        circularLinkedList.add(100);
        circularLinkedList.add(200);
        circularLinkedList.add(300);
        circularLinkedList.add(400);
        circularLinkedList.addFirst(50);
        circularLinkedList.addLast(500);
        printList(circularLinkedList);

        // Simulating Circular behavior
        LinkedList<Integer> simulatedCircularList = new LinkedList<>(circularLinkedList);
        simulatedCircularList.addFirst(simulatedCircularList.getLast()); // Linking last element to the first
        System.out.println("Simulated Circular Linked List:");
        printList(simulatedCircularList);
    }

    // ===================== Print List =====================
    public static void printList(LinkedList<Integer> list) {
        System.out.print("[ ");
        for (Integer elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }

    // ===================== Merge Sort =====================
    // Merge Sort for LinkedList
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; i < mid; i++) {
            left.add(iterator.next());
        }
        while (iterator.hasNext()) {
            right.add(iterator.next());
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    // Merge two sorted lists
    public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> result = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst() <= right.getFirst()) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }

        result.addAll(left);
        result.addAll(right);

        return result;
    }

    // ===================== Delete Element =====================
    // Delete element from the LinkedList
    public static LinkedList<Integer> deleteElement(LinkedList<Integer> list, int value) {
        list.remove(Integer.valueOf(value)); // Removes the first occurrence of the element
        return list;
    }
}
