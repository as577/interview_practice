package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BNode;

public class PathsWithSum {
    
    private static int count = 0;
    
    /**
     * Call {@link #countHelper(BNode, int)} for every node in the tree
     * 
     * @param root
     * @param sum
     */
    public static void count(BNode<Integer> root, int sum) {
        if(root != null) {
            countHelper(root, 0, sum);
            count(root.left, sum);
            count(root.right, sum);
        }
    }
    
    /**
     * Counts number of paths that sum to the given sum with the root as the root of the tree
     * 
     * @param root
     * @param sum
     */
    public static void countHelper(BNode<Integer> root, int running, int target) {
        if(root != null) {
            running += root.data;
            if(running == target) {
                count++;
                return;
            }
            countHelper(root.left, running, target);
            countHelper(root.right, running, target);
        }
    }
    
    // TEST:
    // Tree                     10
    // Sum: 10
    // 
    // countHelper(node(10), 0, 10)
    //       --> running = 0 + 10 = 10
    //       --> running == target is true, so count++ (=1), and returns
    // count(node(10).left) --> returns
    // count(node(10).right) --> returns
    //
    // this gives us the right answer
    //
    // 
    
    public static void main(String[] args) {
        BNode<Integer> n4 = new BNode<Integer>(4);
        BNode<Integer> n3 = new BNode<Integer>(3);
        BNode<Integer> n2 = new BNode<Integer>(2);
        BNode<Integer> n5 = new BNode<Integer>(5);
        BNode<Integer> n6 = new BNode<Integer>(6);
        BNode<Integer> n7 = new BNode<Integer>(7);
        
        n4.left = n5;
        n5.left = n3;
        n5.right = n2;
        n3.right = n7;
        n4.right = n6;
        
        count(n4, 3);
        
        System.out.println("The count is: " + count);
        
    }

}
