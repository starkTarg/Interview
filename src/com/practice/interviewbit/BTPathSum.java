package com.practice.interviewbit;

//Java program for different tree traversals

/* Class containing left and right child of current
node and key value*/
class Node {
    int key;
    Node left, right;

    public Node(int item) {
	key = item;
	left = right = null;
    }
}

class BTPathSum {
    static Node root; // Root of Binary Tree 

    BTPathSum() {
	root = null;
    }

    /*
     * Given a binary tree, print its nodes according to the "bottom-up"
     * postorder traversal.
     */
    void printPostorder(Node node) {
	if (node == null)
	    return;

	// first recur on left subtree
	printPostorder(node.left);

	// then recur on right subtree
	printPostorder(node.right);

	// now deal with the node
	System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(Node node) {
	if (node == null)
	    return;

	/* first recur on left child */
	printInorder(node.left);

	/* then print the data of node */
	System.out.print(node.key + " ");

	/* now recur on right child */
	printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder */
    void printPreorder(Node node) {
	if (node == null)
	    return;

	/* first print data of node */
	System.out.print(node.key + " ");

	/* then recur on left sutree */
	printPreorder(node.left);

	/* now recur on right subtree */
	printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
	printPostorder(root);
    }

    void printInorder() {
	printInorder(root);
    }

    void printPreorder() {
	printPreorder(root);
    }
    
    static boolean haspathSum(Node node, int sum) 
    {
        if (node == null)
            return (sum == 0);
        else
        {
            boolean ans = false;
  
            /* otherwise check both subtrees */
            int subsum = sum - node.key;
            if (subsum == 0 && node.left == null && node.right == null)
                return true;
            if (node.left != null)
                ans = ans || haspathSum(node.left, subsum);
            if (node.right != null)
                ans = ans || haspathSum(node.right, subsum);
            return ans;
        }
    }

    public static int hasPathSum(Node A, int B) {
	
	if(A == null)
	    return 0;
	
	B=B-A.key;
	
	if(B == 0){
	    return 1;
	}
	
	if(B < 0) {
	    return B + A.key;
	}
	
	if(A.left == null && A.right == null)
	    return B;
	 
	
	hasPathSum(A.left, B);
	hasPathSum(A.right, B);
	
	return 0;
	

    }

    // Driver method
    public static void main(String[] args)
	{
		BTPathSum tree = new BTPathSum();
		tree.root = new Node(5);
		tree.root.left = new Node(4);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(11);
		tree.root.right.left = new Node(13);
		tree.root.right.right = new Node(4);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.right = new Node(2);
		tree.root.right.right.right = new Node(1);
		
		//System.out.println("Is their sucj a path ? " + tree.hasPathSum(root, 22));
		System.out.println(haspathSum(root,22));

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}
}
