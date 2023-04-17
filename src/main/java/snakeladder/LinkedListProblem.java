package snakeladder;
public class LinkedListProblem {
    /*
       Input :  1->3->8->10->15 ->22->14->25
       Expected Output :1->15->3->22->8->14->10->25
    */
    public Node print(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow is at middle
       Node temp = node;
       Node slowtemp = node;
        while (temp.next != null && slowtemp.next != null) {
            if (temp == node) {
                Node localTemp  = node.next;
                temp.next = slow;
                slow.next = localTemp;
                temp = temp.next;
                slowtemp = slowtemp.next;
            } else {
                temp = temp.next;
                Node localTemp  = temp.next;
                temp.next = slow;
                slow.next = localTemp;
                temp = temp.next;
                slowtemp = slowtemp.next;
            }
        }
        while (slow != null) {
            temp.next = slow;
            slow = slow.next;
        }

        return temp;

    }

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        System.out.println(new LinkedListProblem().print(node));
    }


}
