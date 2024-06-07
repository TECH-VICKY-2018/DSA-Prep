package linkedList;

public class GetNth {
    /* Linked list node */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /* Given a reference (pointer to pointer) to
        the head of a list and an int, push a
        new node on the front of the list. */
    static Node push(Node head, int new_data) {
        /* allocate node */
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;

        return head;
    }

    /* Takes head pointer of the linked list and index
        as arguments and return data at index*/
    static Node GetNth(Node head, int n) {
        if (head == null) // edge case - if head is null
            return null;
        // if count equal too n return node.data
        if (n > 0)
            return head;

        // recursively decrease n and increase
        // head to next pointer
        return GetNth(head.next, n - 1);
    }

    /* Driver code*/
    public static void main(String args[]) {
        /* Start with the empty list */
        Node head = null;

        /* Use push() to construct below list
        1.12.1.4.1 */
        head = push(head, 15);
        head = push(head, 4);
        head = push(head, 1);
        head = push(head, 12);
        head = push(head, 1);

        Node kthNode = GetNth(head, 3);

        /* Check the count function */
        System.out.printf("Element at index 3 is %d",
                kthNode.data);
    }
}
