package com.practice.leet;
//Definition for singly-linked list.

class Solution {

    static ListNode head1;
    static ListNode head2;

    static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

	int carry = 0;
	ListNode resHead = null;
	ListNode node;
	while (l1 != null && l2 != null) {

	    int summed = l1.val + l2.val + carry;
	    carry = 0;
	    if (summed > 9) {
		node = new ListNode(summed % 10);
		carry = summed / 10;
	    } else {
		node = new ListNode(summed);
	    }
	    resHead = insertNodeAtLast(resHead, node);
	    l1 = l1.next;
	    l2 = l2.next;
	}

	while (l1 != null) {
	    l1.val = l1.val + carry;
	    carry = 0;
	    if (l1.val > 9) {
		node = new ListNode(l1.val % 10);
		carry = l1.val / 10;
	    } else {
		node = new ListNode(l1.val);
	    }
	    resHead = insertNodeAtLast(resHead, node);
	    l1 = l1.next;
	}
	while (l2 != null) {
	    l2.val = l2.val + carry;
	    carry = 0;
	    if (l2.val > 9) {
		node = new ListNode(l2.val % 10);
		carry = l2.val / 10;
	    } else {
		node = new ListNode(l2.val);
	    }

	    resHead = insertNodeAtLast(resHead, node);
	    l2 = l2.next;
	    
	}

	if (carry != 0) {
	    ListNode tempNode = new ListNode(carry);
	    resHead = insertNodeAtLast(resHead, tempNode);
	}

	return resHead;

    }

    private ListNode insertNodeAtLast(ListNode resHead, ListNode node) {
	if (resHead == null) {
	    // node.next = resHead;
	    resHead = node;
	} else {
	    node.next = null;

	    /* 5. Else traverse till the last node */
	    ListNode last = resHead;
	    while (last.next != null)
		last = last.next;

	    /* 6. Change the next of last node */
	    last.next = node;
	}
	return resHead;
    }

    public static void main(String[] args) {
	Solution list1 = new Solution();
	list1.head1 = new ListNode(1);
	// list1.head1.next = new ListNode(8);
	// list1.head1.next.next = new ListNode(3);

	Solution list2 = new Solution();
	list2.head2 = new ListNode(9);
	list2.head2.next = new ListNode(9);
	// list2.head2.next.next = new ListNode(4);

	ListNode result = new Solution().addTwoNumbers(head1, head2);
	while (result != null) {
	    System.out.print(result.val);
	    result = result.next;
	    if (result != null)
		System.out.print(" -> ");
	}

    }
}