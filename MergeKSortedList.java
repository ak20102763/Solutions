class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

		ListNode sortedRes = new ListNode(Integer.MIN_VALUE), head = sortedRes, prev = null;
		if (lists.length == 0)
			return null;

		for (int i = 0; i < lists.length; i++) {

			var next = lists[i];
			sortedRes = head;

			while (sortedRes != null && next != null) {

				if (sortedRes.val > next.val) {
					propagateBack(head, next.val);
					next = next.next;
				} else {
					while (sortedRes != null && sortedRes.val <= next.val) {
						prev = sortedRes;
						sortedRes = sortedRes.next;
					}
					ListNode temp = next.next;
					prev.next = next;
					next.next = sortedRes;
					next = temp;
					sortedRes = prev;
				}
			}
		}
		return head.next;
	}

	public ListNode propagateBack(ListNode l, int val) {

		ListNode newNode = new ListNode(val), prev = new ListNode(Integer.MIN_VALUE), head = l;

		while (l != null) {
			if (l.val >= newNode.val && prev != null && prev.val <= newNode.val) {
				prev.next = newNode;
				newNode.next = l;
				break;
			} else if (prev == null && newNode.val <= l.val) {
				newNode.next = l;
				return newNode;
			}
			prev = l;
			l = l.next;
		}

		return head;

	}
}


// with Priority Queue

class PriorityQueue{

        public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=0;i<lists.length;i++) {
			while(lists[i]!=null) {
				queue.offer(lists[i].val);
				lists[i] = lists[i].next;
			}
		}
		
		ListNode res = new ListNode(0), head = res;
		
		while(!queue.isEmpty()) {
			res.next = new ListNode(queue.poll());
			res = res.next;
		}
		
		return head.next;
    }

}