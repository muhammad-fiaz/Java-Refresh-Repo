
public class CircularLinkedListExample {

    // Circular Linked List Node class
    static class CircularLinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = this;
            }
        }

        // Add a node at the end
        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = head;
            }
        }

        // Add a node at the beginning
        public void prepend(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                newNode.next = head;
                head = newNode;
                temp.next = head;
            }
        }

        // Delete a node by value
        public void deleteNode(int key) {
            if (head == null) {
                return;
            }
            if (head.data == key) {
                if (head.next == head) {
                    head = null;
                } else {
                    Node temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                }
                return;
            }
            Node temp = head;
            while (temp.next != head && temp.next.data != key) {
                temp = temp.next;
            }
            if (temp.next == head) {
                return;
            }
            temp.next = temp.next.next;
        }

        // Print the list
        public void printList() {
            if (head == null) return;
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.prepend(5);
        list.printList(); // Output: 5 10 20 30

        list.deleteNode(20);
        list.printList(); // Output: 5 10 30
    }
}
