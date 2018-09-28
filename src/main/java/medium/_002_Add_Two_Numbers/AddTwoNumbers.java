package medium._002_Add_Two_Numbers;

import structure.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * 给定两个非空链表来表示两个非负整数。
 * 位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    private ListNode listNode1 = ListNode.createTestData("[2,4,3]");
    private ListNode listNode2 = ListNode.createTestData("[5,6,4]");
    private ListNode target = ListNode.createTestData("[7,0,8]");

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO: 2018/9/28 0028 your answer
        return null;
    }

    /**
     * 题目重点1 是倒序 重点2是记得要进位 重点三 两个链表不一定一样长 重点四 有一个链表可能为空
     */
    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        int carry = 0;
        int l1Value;
        int l2Value;
        int sum;
        while (listNode1 != null || listNode2 != null) {
            l1Value = listNode1 == null ? 0 : listNode1.val;
            l2Value = listNode2 == null ? 0 : listNode2.val;
            sum = l1Value + l2Value + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (listNode1 != null) listNode1 = listNode1.next;
            if (listNode2 != null) listNode2 = listNode2.next;
        }
        if (carry > 0) temp.next = new ListNode(carry);
        return listNode.next;
    }

    /**
     * 官方答案
     */
    public ListNode solutionAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 最快答案
     * 仔细看了一下 应该是根据测试用例 在 while判断循环条件的地方进行了刻意的优化 所以耗时少很多
     */
    public ListNode faststAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode pointer = ans;
        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            carry = l1 == null ? carry : carry + l1.val;
            carry = l2 == null ? carry : carry + l2.val;
            pointer.next = new ListNode(carry % 10);
            carry /= 10;
            pointer = pointer.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) pointer.next = new ListNode(carry);
        return ans.next;
    }
}