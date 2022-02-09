package miji._01array._04shuanzhizhen;

public class P141 {
	public boolean hasCycle(ListNode head) {
		ListNode first, second;
		first = second = head;
		while (first != null && first.next != null) {
			first = first.next.next;
			second = second.next;
			if (first == second) {
				return true;
			}
		}
		return false;
	}
}


//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}


