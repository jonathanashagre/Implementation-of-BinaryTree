public class BinaryTree {
    
    public static class Node{
        int data;
        Node left;
        Node  right;

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setRight(Node right){
            this.right = right;
        }
        public Node getRight(){
            return this.right;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public Node getLeft(){
            return this.left;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return this.data;
        }
    }
/*class attributes */
    Node root;
    int size;

/*constructor */
    public BinaryTree(Node root){
        this.root = root;
        size = 0;
    }

    /* pre-order */
    public void preorderHelper(Node node){
        if (node == null){
            return;
        }
        else {
            System.out.print(node.data + " --> ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
        return;
    }

    public void preorder(){
        preorderHelper(root);
    }

    public void inorderHelper(Node node){
        if (node == null){
            return;
        }
        else{
            inorderHelper(node.left);
            System.out.print(node.data + " --> ");
            inorderHelper(node.right);
        }
        return;
    }

    public void inorder(){
        inorderHelper(root);
    }

    public void postorderHelper(Node node){
        if (node == null){
            return;
        } 
        else{
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(node.data + " --> ");
        }
        return;

    }
    public void postOrder(){
        postorderHelper(root);
    }
    public int searchIterative(int[] a, int left, int right, int target){
        if(left > right){
            System.out.println("Not found");
            return -1;
        }
        else{
            while(left <= right){
                int mid = (left +right) / 2;
                if(target == a[mid]){
                    System.out.println(target + " found at index " + mid);
                    return target;
                }
                else if(target < a[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    public int searchRecursive(int[] a, int left, int right, int target){
        if(left > right){
            System.out.println("Not found");
            return -1;
        }
        else {
            int mid = (left +right) / 2;
            if(target == a[mid]){
                System.out.println("target is found at index" + mid);
                return target;
            }
            else if(target < a[mid]){
                return searchIterative(a, left, mid - 1, target);
            }
            else{
                return searchRecursive(a, mid + 1, right, target);
            }
        }
    }
    public int searchNodeRecursive(Node node, int value){
        //case 1--> if the tree is empty, you can't search
        if(node == null){
            return -1;
        }
        
        //case 2--> if the element is inside the tree
        if(value == node.getData()){
            System.out.println("Element found");
            return value;
        }
        //case -->3 if the element is less than the root (meaning its on the left side)
        if(value < node.getData()){
            return searchNodeRecursive(node.left , value);
        }
        //case -->3 if the element is greater than the root (meaning its on the right side)
        else{
            return searchNodeRecursive(node.right, value);
        }
    }

    public int searchNodeIterativly(Node node, int value){
        //case 1--> if the tree is empty
        if(node == null){
            return -1;
        }
        //case 2--> if the element is inside the tree
        if(value == node.getData()){
            System.out.println("Found element");
            return value;
        }
        //case 3--> if the element is less than the root (meaning its on the left side)
        if(value < node.getData()){
           node = node.left;
        }
        else{
            node = node.right;
        }
       return -1;
    }
    public Node add(Node node, int value){
        if(node == null){
            return new Node(value, null, null);
        }
        //case 2--> check left
        if(value < node.getData()){
            node.left = add(node.left, value);
        }
        //case 3--> check right
        if(value > node.getData()){
            node.right = add(node.right, value);
        }
        return node;
    }
    public void replace(Node node, int value){
        //case 1--> check left side
        if(value < node.getData()){
                if(node.left == null){
                    node.setData(value);
                }
                else{
                    replace(node.left, value);
                }
        }
        //case 2--> check right side
        if(value > node.getData()){
            if(node.right == null){
                node.setData(value);
            }
            else{
                replace(node.right, value);
            }
        }
    }

    public Node remove(Node node, int value){
        //case 1--> check if tree is empty
        if(node == null){
            return null;
        }
       
        if(value == node.getData()){
            System.out.println("Found " + value);
            return node.right;
        }
        if(value < node.getData()){
            node.left = remove(node.left, value);
            return node;
        }
        else{
            node.right = remove(node.right, value);
            return node;
        }
    }
    public static void main(String[] args) {
    //Transvering through binary tree:
        /*BinaryTree p2Tree = new BinaryTree(new Node(2,
        new Node(4, null, null),
        new Node(5, null, null)));
        System.out.println();
        p2Tree.inorder();
        System.out.println();
        p2Tree.preorder();
        System.out.println();
        p2Tree.postOrder();
        */

    //Searching for an element in a binary tree 
        /*BinaryTree p2Tree = new BinaryTree(new Node(2,
        new Node(4, null, null),
        new Node(5, null, null)));
        p2Tree.searchNodeRecursive(p2Tree.root, 2);
        p2Tree.searchNodeRecursive(p2Tree.root, 2);
        */

    //Adding elements to a binary tree
        /*BinaryTree p3Tree = new BinaryTree(new Node(2,
        new Node(4, null, null),
        new Node(5, null, null)));
        p3Tree.add(p3Tree.root, 1);
        System.out.println();
        p3Tree.inorder();
        System.out.println();
        p3Tree.preorder();
        System.out.println();
        p3Tree.postOrder();
        */

    //Replacing elements in a binary tree
        /* BinaryTree p2Tree = new BinaryTree(new Node(2,
        new Node(4, null, null),
        new Node(5, null, null)));
        p2Tree.replace(p2Tree.root, 1);
        System.out.println();
        p2Tree.inorder();
        System.out.println();
        p2Tree.preorder();
        System.out.println();
        p2Tree.postOrder();
        */

    //Remove elements from a binary tree
        BinaryTree p2Tree = new BinaryTree(new Node(2,
        new Node(4, null, null),
        new Node(5, null, null)));
        p2Tree.remove(p2Tree.root, 4);
        System.out.println();
        p2Tree.inorder();
        System.out.println();
        p2Tree.preorder();
        System.out.println();
        p2Tree.postOrder();
        
            
    }
}