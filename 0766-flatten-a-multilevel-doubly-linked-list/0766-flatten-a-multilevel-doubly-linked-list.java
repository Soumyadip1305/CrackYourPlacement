/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
       if (head == null) return null;
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node curr = head;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node child = dfs(curr.child);

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                if (next != null) {
                    child.next = next;
                    next.prev = child;
                }
                last = child;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;  
    }
}