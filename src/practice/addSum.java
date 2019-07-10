package practice;

/**
 * @param :
 * @author : Jiang Erling
 * @date : created in 2019/7/10 16:36
 * @return :
 * @description :将两个以倒叙形式存在链表中的整型数据相加，并以相同形式返回
 */
public class addSum {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null){
            if(l2 == null)
                return null;
            l1 = new ListNode(0);
        }
        if(l2 == null)
            l2 = new ListNode(0);
        int sum = l1.val + l2.val;
        if(sum > 9){
            sum %= 10;
            if(l1.next == null)
                l1.next = new ListNode(0);
            l1.next.val++;
        }
        ListNode result = new ListNode(sum);
        result.next = addTwoNumbers(l1.next , l2.next);
        return result;
    }

    public static final void main(String[] args){
        ListNode l1 = new ListNode(0),l2 = new ListNode(0);
        getLists(l1, l2);
        outList(l1);
        System.out.print("\n");
        outList(l2);
        System.out.print("\n");
        ListNode result = addTwoNumbers(l1,l2);

        /*可以发现，在运行前后，原本的值可能发生了变化*/
        outList(l1);
        System.out.print("\n");
        outList(l2);
        System.out.print("\n");

        outList(result);
        System.out.print("\n");
    }

    private static void getLists(ListNode listNode1 , ListNode listNode2){
        listNode1.val = 2;
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        listNode2.val = 9;
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
    }

    /*我用递归写了输出的函数！！！！递归太神奇了！！！*/
    private static void outList(ListNode node){
        if(node.next != null)
            outList(node.next);
        System.out.print(node.val);
    }
}
