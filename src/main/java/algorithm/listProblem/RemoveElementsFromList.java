package algorithm.listProblem;

import util.MyUtil;

import java.util.List;

/**
 * 删除数组中指定val的所有元素
 * 两种实现
 */
public class RemoveElementsFromList {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    private static ListNode removeEle(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeEle(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode listNode = removeElements(node1, 6);
        ListNode listNode = removeEle(node1, 6);
        MyUtil.printList(listNode);
    }
}
