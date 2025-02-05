import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        // ===================== Stack Operations =====================
        Stack<Integer> stack = new Stack<>();

        // 1. Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack after push operations: " + stack);

        // 2. Peek at the top element (without removing it)
        System.out.println("Top element (peek): " + stack.peek());

        // 3. Pop elements from the stack (removes and returns the top element)
        System.out.println("Popped element (pop): " + stack.pop());
        System.out.println("Stack after pop operation: " + stack);

        // 4. Check if the stack contains a specific element
        System.out.println("Stack contains 20: " + stack.contains(20));
        System.out.println("Stack contains 50: " + stack.contains(50));

        // 5. Search for an element in the stack (1-based index)
        System.out.println("Position of 30 in the stack (search): " + stack.search(30)); // Returns 1 if found
        System.out.println("Position of 50 in the stack (search): " + stack.search(50)); // Returns -1 if not found

        // 6. Get the size of the stack
        System.out.println("Stack size: " + stack.size());

        // 7. Check if the stack is empty
        System.out.println("Stack is empty: " + stack.isEmpty());

        // 8. Clear all elements from the stack
        stack.clear();
        System.out.println("Stack after clear operation: " + stack);

        // 9. Push new elements after clearing the stack
        stack.push(100);
        stack.push(200);
        stack.push(300);
        System.out.println("Stack after pushing new elements: " + stack);

        // 10. Demonstrating Iteration using for-each loop
        System.out.print("Iterating stack elements: ");
        for (Integer elem : stack) {
            System.out.print(elem + " ");
        }
        System.out.println();

        // 11. Demonstrating Iteration using Iterator
        Iterator<Integer> iterator = stack.iterator();
        System.out.print("Iterating stack using Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 12. Convert Stack to Array
        Object[] stackArray = stack.toArray();
        System.out.print("Stack as Array: ");
        for (Object obj : stackArray) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // 13. Demonstrating clone() method
        Stack<Integer> clonedStack = (Stack<Integer>) stack.clone();
        System.out.println("Cloned stack: " + clonedStack);
    }
}
