public class l004_LinkedListCycle {
	
    public static boolean isCyclePresentInLL(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;

        }

        return false;
    }

    public static ListNode CycleNode(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast != slow)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static ListNode CycleNode2(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast != slow)
            return null;

        ListNode meetingNode = fast;
        int a = 0, b = 0, c = 0, bc = 0, nDash = 0, n = 0; // bc is (b + c)F

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

            if (fast == meetingNode)
                nDash++;
            a++;
        }

        fast = meetingNode;
        fast = fast.next;

        bc = 1;
        while (fast != meetingNode) {
            fast = fast.next;
            bc++;
        }

        n = nDash + 1;
        c = a - bc * nDash;
        b = bc - c;

        System.out.println("Length Of Tail is:" + a);
        System.out.println("Length Of b is:" + b);
        System.out.println("Length Of c is:" + c);
        System.out.println("No Of rotation by fast pointer before meeting poiny:" + n);
        System.out.println("No Of rotation by fast pointer after meeting poiny:" + nDash);

        return slow;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode tail = headA;
        while (tail.next != null)
            tail = tail.next;

        tail.next = headB;
        ListNode ans = CycleNode(headA);
        tail.next = null;

        return ans;
    }

    public static int length(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        ListNode biggerList = lenA > lenB ? headA : headB;
        ListNode smallerList = lenB < lenA ? headB : headA;

        int diff = Math.abs(lenA - lenB);
        while (diff-- > 0)
            biggerList = biggerList.next;

        while (biggerList != smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        return biggerList;
    }
}