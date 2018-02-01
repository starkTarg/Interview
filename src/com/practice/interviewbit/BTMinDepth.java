package com.practice.interviewbit;

public class BTMinDepth {

    static Node root; // Root of Binary Tree

    BTMinDepth() {
	root = null;
    }

    static int minDepth(Node root) {
	// Corner case. Should never be hit unless the code is
	// called on root = NULL
	if (root == null)
	    return 0;

	// Base case : Leaf Node. This accounts for height = 1.
	if (root.left == null && root.right == null)
	    return 1;

	// If left subtree is NULL, recur for right subtree
	if (root.left == null)
	    return minDepth(root.right) + 1;

	// If right subtree is NULL, recur for right subtree
	if (root.right == null)
	    return minDepth(root.left) + 1;

	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // Driver method
    public static void main(String[] args) {
	BTMinDepth tree = new BTMinDepth();
	tree.root = new Node(5); 
	tree.root.left = new Node(4);
	tree.root.right = new Node(8);
	tree.root.left.left = new Node(11);
	tree.root.right.left = new Node(13);
	tree.root.right.right = new Node(4);
	tree.root.left.left.left = new Node(7);
	tree.root.left.left.right = new Node(2);

	System.out.println(minDepth(root));
    }

}
