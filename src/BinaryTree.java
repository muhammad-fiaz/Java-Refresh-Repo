class BinaryTree {

    // Definition for a Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the Binary Tree
    Node root;

    public BinaryTree() {
        root = null;
    }

    // In-order Traversal (Left, Root, Right)
    public void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);  // Traverse left subtree
        System.out.print(node.data + " ");  // Visit root
        inorderTraversal(node.right);  // Traverse right subtree
    }

    // Pre-order Traversal (Root, Left, Right)
    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");  // Visit root
        preorderTraversal(node.left);  // Traverse left subtree
        preorderTraversal(node.right);  // Traverse right subtree
    }

    // Post-order Traversal (Left, Right, Root)
    public void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);  // Traverse left subtree
        postorderTraversal(node.right);  // Traverse right subtree
        System.out.print(node.data + " ");  // Visit root
    }

    // Inserting a new node into the tree (Simple BST insertion)
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);  // If the tree is empty, create a new node
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);  // Insert in left subtree if data is smaller
        } else {
            root.right = insert(root.right, data);  // Insert in right subtree if data is larger
        }

        return root;
    }

    // Searching for a value in the tree
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;  // If root is null, key is not found
        }

        if (key == root.data) {
            return true;  // If root data matches key, return true
        } else if (key < root.data) {
            return search(root.left, key);  // Search in the left subtree
        } else {
            return search(root.right, key);  // Search in the right subtree
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        // Traversals and searching
        System.out.println("In-order Traversal:");
        tree.inorderTraversal(tree.root);  // Should print the sorted tree
        System.out.println("\n");

        System.out.println("Pre-order Traversal:");
        tree.preorderTraversal(tree.root);  // Should print root before children
        System.out.println("\n");

        System.out.println("Post-order Traversal:");
        tree.postorderTraversal(tree.root);  // Should print children before root
        System.out.println("\n");

        // Search for a value
        int searchKey = 40;
        if (tree.search(tree.root, searchKey)) {
            System.out.println("Element " + searchKey + " found in the tree.");
        } else {
            System.out.println("Element " + searchKey + " not found in the tree.");
        }
    }
}
