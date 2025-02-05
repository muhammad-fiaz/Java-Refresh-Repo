public class BinarySearchTree {

    // Node class to define the structure of the tree
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Root of the BST
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive method to insert a value
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive method to search for a value
    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    // In-order traversal (Left, Root, Right)
    public void inorderTraversal() {
        inorderRec(root);
    }

    // Recursive method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preorderTraversal() {
        preorderRec(root);
    }

    // Recursive method for preorder traversal
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postorderTraversal() {
        postorderRec(root);
    }

    // Recursive method for postorder traversal
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Inorder Traversal (Should print in sorted order)
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();
        System.out.println();

        // Preorder Traversal
        System.out.println("Preorder Traversal:");
        tree.preorderTraversal();
        System.out.println();

        // Postorder Traversal
        System.out.println("Postorder Traversal:");
        tree.postorderTraversal();
        System.out.println();

        // Search for an element
        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));
    }
}
