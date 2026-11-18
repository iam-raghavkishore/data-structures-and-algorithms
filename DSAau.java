public class DSAau {
    static class Node {
        Node next;
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
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        Node fourth = new Node();

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        System.out.println(hasCycle(first));
    }
}
