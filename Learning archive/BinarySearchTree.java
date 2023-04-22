public class BinarySearchTree<E extends Comparable<E> >   {

    private static class Node<E> {
        private Node<E> left, right;
        private E value;
        private Node(Node<E> left, Node<E> right, E value ) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    

    private Node<E> current;

    // tree traversal through the binary search tree itself.

    private void visit(Node<E> current) {
        System.out.println(" " + current.value);
    }

    public void preOrder() {
        preOrder(current);
    }

    public void inOrder() {
        inOrder(current);
    }

    public void postOrder() {
        postOrder(current);
    }

    public boolean contains(E obj) {
        if ( obj == null) {
            throw new NullPointerException();
        }
        else if (current == obj) {
            return true;
        }

        return contains(obj, current);
    }

    private boolean contains(E obj, Node<E> current) {
        boolean result = false;
        int test = obj.compareTo(current.value);
        if (test < 0) {
            result = contains(obj, current.left);
        }
        else if (test > 0) {
            result = contains(obj, current.right);
        }
        else if ( test == 0) {
            result = true;
        }

        return result;
    }

    public boolean contains2(E obj) {
        if (obj == null) {
            return false;
        }
        else if (obj == current) {
            return true;
        }

        boolean found = false; 
        int test = 0;

        while (! found && current != null) {
            test = obj.compareTo(current.value);
            if (test < 0) {
                current = current.left;
            }
            else if (test > 0) {
                current = current.right;
            }
            else if (test == 0) {
                found = true;
            }
        }

        return found;
    }
    private void preOrder(Node<E> current) { // travels through and completely explores the left sub-tree first, before exploring the right sub-tree of the BST. Goes from top to bottom; left sub-tree to right subtree.
                                            // before doing so, it will always announce the root node first.
        if (current != null) {
            visit(current);
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    private void postOrder(Node<E> current) { // goes through from the bottom of the BST; goes up to the top. 
                                            // post order goes in the opposite direction; so for every layer, we go from bottom to top
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            visit(current);
        }
    }

    private void inOrder(Node<E> current) {
        // tbh ; don't really understand how this works.... but inOrder essentially goes through and goes through both the left and right sub-tree  and goes deep until it hits a leaf;
            // after tha.... I got no clue

        if (current != null) {
            inOrder(current.left);
            visit(current);
            inOrder(current.right);
        }
    }

}
