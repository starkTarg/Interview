package com.practice.interviewbit;

public class BTMaxDepth {

    static Node root; // Root of Binary Tree

    BTMaxDepth() {
	root = null;
    }

    static int maxDepth(Node root) {


	if (root == null) {
	    return 0;
	} else {

	    int leftDepth=0, rightDepth=0;
	    if (root.left != null) {
		leftDepth = maxDepth(root.left);
	    }

	    if (root.right != null) {
		rightDepth = maxDepth(root.right);
	    }
	    
	    if(leftDepth > rightDepth)
		return leftDepth+1;
	    else 
		return rightDepth +1;

	}

    }

    // Driver method
    public static void main(String[] args) {
	BTMaxDepth tree = new BTMaxDepth();
	tree.root = new Node(5);
	tree.root.left = new Node(4);
	tree.root.right = new Node(8);
	tree.root.left.left = new Node(11);
	tree.root.right.left = new Node(13);
	tree.root.right.right = new Node(4);
	tree.root.left.left.left = new Node(7);
	tree.root.left.left.right = new Node(2);
	tree.root.right.right.right = new Node(1);
	tree.root.right.right.right.right = new Node(1);

	System.out.println(maxDepth(root));
    }

}
