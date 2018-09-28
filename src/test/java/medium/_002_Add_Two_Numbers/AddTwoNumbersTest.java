package medium._002_Add_Two_Numbers;

import org.junit.Test;
import structure.ListNode;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    private ListNode listNode1 = ListNode.createTestData("[2,4,3]");
    private ListNode listNode2 = ListNode.createTestData("[7,6,9]");

    @Test
    public void addTwoNumbers() {
    }

    @Test
    public void myAddTwoNumbers() {
        assertEquals(ListNode.createTestData("[9,0,3,1]"), new AddTwoNumbers().myAddTwoNumbers(listNode1, listNode2));
    }

    @Test
    public void faststAddTwoNumbers() {
        assertEquals(ListNode.createTestData("[9,0,3,1]"), new AddTwoNumbers().faststAddTwoNumbers(listNode1, listNode2));
    }
}