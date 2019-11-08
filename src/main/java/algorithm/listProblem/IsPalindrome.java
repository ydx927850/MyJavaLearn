package algorithm.listProblem;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/31 11:12
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            //分别对应长度为奇数和偶数的情况
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next==null){
            //奇数
            slow = reverseList(slow);
        }else{
            //偶数
            slow = reverseList(slow.next);
        }
        while(head!=slow && slow!=null){
            if(head.val!=slow.val){
                return false;
            }else{
                head = head.next;
                slow = slow.next;
            }
        }
        return true;
    }

    private static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    private static String listToString(ListNode node){
        if(node==null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        while(node!=null){
            str.append(String.valueOf(node.val));
            node = node.next;
        }
        System.out.println(str.toString());
        return str.toString();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        System.out.println(isPalindrome(node1));
    }
}
