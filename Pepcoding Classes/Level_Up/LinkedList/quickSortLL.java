public class quickSortLL {
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

    public static ListNode[] mergeElement(ListNode[] left, ListNode pivotNode, ListNode[] right){

        ListNode head = null;
        ListNode tail = null;
        if(left[0] != null && right[0] != null){
            left[1].next = pivotNode;
            pivotNode.next = right[0];

            head = left[0];
            tail = right[1];
        } else if(left[0] != null) {
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

        return new ListNode[]{head, tail};
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

    public static ListNode SortLL(ListNode head) {
        return quickSort(head)[0];
    }

}
