

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Step 1: Create Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 2: Add all first nodes (heads)
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        // Step 3: Create dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 4: Process until heap is empty
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll(); // get smallest node

            current.next = smallest; // attach to result
            current = current.next;

            // If next node exists, add it to heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        // Step 5: Return merged list
        return dummy.next;
    }
}