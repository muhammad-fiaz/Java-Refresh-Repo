
public class SinglyLinkedListExample {

    // Singly Linked List Node class
    static class SinglyLinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Add a node at the end
        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Add a node at the beginning
        public void prepend(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Delete a node by value
        public void deleteNode(int key) {
            if (head == null) {
                return;
            }
            if (head.data == key) {
                head = head.next;
                return;
            }
            Node temp = head;
            while (temp.next != null && temp.next.data != key) {
                temp = temp.next;
            }
            if (temp.next == null) {
                return;
            }
            temp.next = temp.next.next;
        }

        // Print the list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);
        list.printList(); // Output: 5 10 20 30

        list.deleteNode(20);
        list.printList(); // Output: 5 10 30
    }
}
