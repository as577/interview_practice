package ch2.linkedlists.practice;

import java.util.HashSet;
import java.util.Set;

import ch2.linkedlists.implementations.LinkedList.Node;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * 
 * @author Aditya Srinivasan
 *
 */
public class LoopDetection {

    //
    // Assumptions:
    // 1) Singly linked list
    // 
    // Check:
    // 1) Head node is null
    //
    // Example:
    // A -> B -> C -> D -> E -> C, since C is the loop
    //
    // We can use the runner technique in order to determine IF there is a loop at all.
    // We have one pointer that moves twice for every one time that the first pointer moves.
    // If there is a loop, then the two will collide at one point, if not then the fast one will hit a null and we return null
    //
    // Once we determine that there is a loop, we must determine where the start of the loop is
    //
    // If we traverse the list, the first node we've seen already is the start of our cycle.
    // 

    public static Node loop(Node head) {
    
        if(head == null) return null;
    
        Node slow = head;
        Node fast = head;
        
        boolean collision = false;
        
        while(fast != null && fast.next != null) {
            if(slow == fast) {
                collision = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(!collision) return null;
        
        Node current = head;
        
        Set<Node> seen = new HashSet<Node>();
        
        while(current != null) {
            if(seen.contains(current)) {
                return current;
            }
            seen.add(current);
            current = current.next;
        }
        
        return null;
        
        // This is O(N) runtime and O(N) space
    }
    
    public static void main(String[] args) {
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n4;
        
        System.out.println(LoopDetection.loop(n1).data);
        
    }

}
