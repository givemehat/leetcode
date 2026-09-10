class Solution:
    def mergeTwoLists(self, list1, list2):
        """Merge two sorted singly linked lists into one sorted list.

        Args:
            list1: head of the first sorted list (ListNode or None)
            list2: head of the second sorted list (ListNode or None)

        Returns:
            Head of the merged sorted list (ListNode or None). Nodes are
            reused from the inputs (no new node allocation beyond a dummy).

        The dummy head simplifies edge cases; remaining tail of whichever
        list is non-empty is spliced on at the end.
        """
        dummy = ListNode(0)
        current = dummy

        while list1 and list2:
            if list1.val <= list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next

            current = current.next

        # Attach remaining nodes
        if list1:
            current.next = list1
        else:
            current.next = list2

        return dummy.next
