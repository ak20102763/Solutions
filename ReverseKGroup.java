class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

		ListNode first = head, reversedList = null, headFirst = head, prev = null, nextKList = null;
		int count = 0;

		while (head != null) {
			first = head;
			count = 0;
			ListNode tempHead = head;
			while (count < k - 1 && first.next != null) {
				first = first.next;
				count++;
			}
			if (first != null) {
				nextKList = first.next;
				head = first.next;
			}
			if (k - 1 == count && first != null) {
				first.next = null;
				reversedList = reverseList(tempHead);
				tempHead.next = nextKList;
				if (prev != null)
					prev.next = reversedList;
				else
					headFirst = reversedList;
				prev = tempHead;
			} else {
				if (prev != null) {
					prev.next = tempHead;
				}
				break;
			}
		}

		return headFirst;

	}

	public ListNode reverseList(ListNode head) {

		ListNode prev = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		return prev;

	}
}