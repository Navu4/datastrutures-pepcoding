import java.util.List;

public class l003_LinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public static ListNode[] segregate(ListNode head, int pivotIdx) {

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);

        ListNode sp = small, lp = large, curr = head;

        ListNode pivotNode = head;
        while (pivotIdx-- > 0)
            pivotNode = pivotNode.next;

        while (curr != null) {
            if (curr != pivotNode) {
                if (curr.val <= pivotNode.val) {
                    sp.next = curr;
                    sp = sp.next;
                } else {
                    lp.next = curr;
                    lp = lp.next;
                }
            }
            curr = curr.next;
        }

        pivotNode.next = null;
        sp.next = null;
        lp.next = null;

        return new ListNode[] { small.next, pivotNode, large.next };
    }

    public static ListNode[] mergeElement(ListNode[] left, ListNode pivotNode, ListNode[] right) {

        ListNode head = null;
        ListNode tail = null;
        if (left[0] != null && right[0] != null) {
            left[1].next = pivotNode;
            pivotNode.next = right[0];

            head = left[0];
            tail = right[1];
        } else if (left[0] != null) {
            left[1].next = pivotNode;

            head = left[0];
            tail = pivotNode;
        } else if (right[0] != null) {
            pivotNode.next = right[0];

            head = pivotNode;
            tail = right[1];
        } else {
            head = pivotNode;
            tail = pivotNode;
        }

        return new ListNode[] { head, tail };
    }

    public static ListNode[] quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[] { head, head };
        }

        int len = length(head);
        int pivotIdx = len / 2;

        ListNode[] seggregate = segregate(head, pivotIdx);

        ListNode[] left = quickSort(seggregate[0]);
        ListNode[] right = quickSort(seggregate[2]);

        return mergeElement(left, seggregate[1], right);
    }

    public static ListNode quickSort_(ListNode head) {
        return quickSort(head)[0];
    }

    // Add Two LinkedList

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, forw = null, curr = head;
        while (curr != null) {
            forw = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2, prev = dummy;

        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);

            carry = sum / 10;

            sum %= 10;

            prev.next = new ListNode(sum);
            prev = prev.next;

            if (c1 != null)
                c1 = c1.next;

            if (c2 != null)
                c2 = c2.next;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(dummy.next);
    }

    // Subtract Two Lists 
    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

                ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2, prev = dummy;
        int borrow = 0;
        while (c1 != null || c2 != null) {
            int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else
                borrow = 0;

            prev.next = new ListNode(diff);
            prev = prev.next;

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        ListNode head = dummy.next;
        head = reverse(head);

        while (head != null && head.val == 0) // 1000000000 - 99999999 = 1, 999 - 999 = 0
            head = head.next;

        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(dummy.next);
    }

    public static void main(String[] args) {

    }
}