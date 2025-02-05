
public class  DoublyLinkedListExample {

    // Doubly Linked List Node class
    static class DoublyLinkedList {
        Node head, tail;

        static class Node {
            int data;
            Node next, prev;

            Node(int data) {
                this.data = data;
                this.next = this.prev = null;
            }
        }

        // Add a node at the end
        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        // Add a node at the beginning
        public void prepend(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        // Delete a node by value
        public void deleteNode(int key) {
            if (head == null) {
                return;
            }
            if (head.data == key) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
                return;
            }
            Node temp = head;
            while (temp != null && temp.data != key) {
                temp = temp.next;
            }
            if (temp == null) {
                return;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }

        // Print the list from head to tail
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Print the list from tail to head
        public void printReverseList() {
            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);
        list.printList(); // Output: 5 10 20 30
        list.printReverseList(); // Output: 30 20 10 5

        list.deleteNode(20);
        list.printList(); // Output: 5 10 30
    }
}
