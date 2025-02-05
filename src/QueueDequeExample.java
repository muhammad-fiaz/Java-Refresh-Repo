import java.util.*;

public class QueueDequeExample {
    public static void main(String[] args) {
        // ===================== Queue Example (FIFO) =====================
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.add(10);  // Add element to the end of the queue
        queue.add(20);
        queue.add(30);

        // Print the queue
        System.out.println("Queue after enqueue operations: " + queue);

        // Peek at the front element (without removing it)
        System.out.println("Front element (peek): " + queue.peek());

        // Dequeue elements
        System.out.println("Dequeuing (poll): " + queue.poll()); // Removes the front element
        System.out.println("Queue after dequeue operation: " + queue);

        // Check if queue contains a specific element
        System.out.println("Queue contains 20: " + queue.contains(20));

        // Check the size of the queue
        System.out.println("Queue size: " + queue.size());

        // Check if the queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());

        // ===================== Deque Example (Double-Ended Queue) =====================
        Deque<Integer> deque = new LinkedList<>();

        // Enqueue elements at both ends
        deque.addFirst(10);  // Add element to the front
        deque.addLast(20);   // Add element to the end
        deque.addFirst(5);   // Add element to the front again
        deque.addLast(30);   // Add element to the end again

        // Print the deque
        System.out.println("\nDeque after enqueue operations: " + deque);

        // Peek at the first and last elements (without removing them)
        System.out.println("First element (peekFirst): " + deque.peekFirst());
        System.out.println("Last element (peekLast): " + deque.peekLast());

        // Dequeue elements from both ends
        System.out.println("Dequeuing from front (pollFirst): " + deque.pollFirst());  // Removes from the front
        System.out.println("Dequeuing from end (pollLast): " + deque.pollLast());    // Removes from the end
        System.out.println("Deque after dequeue operations: " + deque);

        // Offer elements at both ends
        deque.offerFirst(15);  // Adds element to the front
        deque.offerLast(25);   // Adds element to the end
        System.out.println("Deque after offer operations: " + deque);

        // Check if deque contains a specific element
        System.out.println("Deque contains 15: " + deque.contains(15));

        // Check the size of the deque
        System.out.println("Deque size: " + deque.size());

        // Check if the deque is empty
        System.out.println("Deque is empty: " + deque.isEmpty());
    }
}
