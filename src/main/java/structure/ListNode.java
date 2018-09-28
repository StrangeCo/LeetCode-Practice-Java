package structure;

/**
 * 链表
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 创建测试数据
     *
     * @param data [XX,XX,XX]
     * @return {@link ListNode}
     */
    public static ListNode createTestData(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        int len = split.length;
        ListNode[] listNode = new ListNode[len + 1];
        listNode[0] = new ListNode(Integer.valueOf(split[0]));
        for (int i = 1; i < len; i++) {
            listNode[i] = new ListNode(Integer.valueOf(split[i]));
            listNode[i - 1].next = listNode[i];
        }
        return listNode[0];
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }
        StringBuilder str = new StringBuilder("[" + String.valueOf(listNode.val));
        ListNode p = listNode.next;
        while (p != null) {
            str.append(",").append(String.valueOf(p.val));
            p = p.next;
        }
        System.out.println(str.append("]"));
    }

    @Override
    public boolean equals(Object obj) {
        ListNode listNode1 = this;
        if (!(obj instanceof ListNode)) return false;
        ListNode listNode2 = (ListNode) obj;
        return isListNodeEquals(listNode1.next, listNode2.next);
    }

    private boolean isListNodeEquals(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null && listNode2 == null) return true;
        if (listNode1 == null) return false;
        if (listNode2 == null) return false;
        if (listNode1.val != listNode2.val) return false;
        return isListNodeEquals(listNode1.next, listNode2.next);
    }
}