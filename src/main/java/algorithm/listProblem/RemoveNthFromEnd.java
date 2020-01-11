package algorithm.listProblem;


import util.MyUtil;

/**
 * 双指针，让第一个指针领先第二个指针n步，这样第一个指针走到倒数第0个（null）时，第二个指针就是倒数第n个
 */
public class RemoveNthFromEnd {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = removeNthFromEnd(node1, 5);
        MyUtil.printList(res);
    }
}
