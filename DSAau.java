public class DSAau {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        // Connect the last node back to the second node.
        fourth.next = second;

        System.out.println(hasCycle(first));
    }
}