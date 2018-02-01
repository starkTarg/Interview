package com.practice.geeks;

import java.util.ArrayList;
import java.util.List;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
	key = item;
	left = right = null;
    }
}

public class KthSmallestBST {

    static Node root; // Root of Binary Tree

    public KthSmallestBST() {

	this.root = null;
    }

    public static int kthsmallest(Node A, int B) {

	List list = new ArrayList<>();
	doInorder(A, list, 0);
	int kthItem=0;
	for(int i=0 ;i < list.size(); i++) {
	    if(i+1 == B) {
		kthItem = (int) list.get(i);
		break;
	    }
	}

	return kthItem;
    }

    private static void doInorder(Node a, List inorder, int count) {

	if (a == null) {
	    return;
	}
	doInorder(a.left, inorder, count);
	if(a != null)
	inorder.add(a.key);
	doInorder(a.right, inorder, count);

    }

    public static void main(String[] args) {

	KthSmallestBST tree = new KthSmallestBST();
	tree.root = new Node(2);
	tree.root.left = new Node(1);
	tree.root.right = new Node(3);

	System.out.println(kthsmallest(root, 2));

	// tree.root.left.left = new Node(11);
	// tree.root.right.left = new Node(13);
	// tree.root.right.right = new Node(4);
	// tree.root.left.left.left = new Node(7);
	// tree.root.left.left.right = new Node(2);
	// tree.root.right.right.right = new Node(1);
    }

}
