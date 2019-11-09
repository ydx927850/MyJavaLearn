package algorithm.listProblem;


import util.MyUtil;

public class RemoveNthFromEnd {
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        boolean isKey = false;
        while(!isKey){
            ListNode tmp = head;
            for(int i=0;i<n;i++){
                tmp = tmp.next;
            }
            if(tmp == null){
                isKey = true;
                head.val = head.next.val;
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return pre.next;
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
        ListNode res = removeNthFromEnd(node1,5);
        MyUtil.printList(res);
    }
}
