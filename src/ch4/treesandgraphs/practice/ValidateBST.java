package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ValidateBST {

    // Given a binary tree, we need to determine whether it is a binary search tree. To clarify, a binary search tree
    // is a binary tree where, for every node n, the left subtree has values all lower than n and the right subtree
    // has values all greater than n.
    //
    // We'll assume that if there are duplicates, then they will be in the left tree, so the left tree has values all lower
    // than OR EQUAL to n.
    //
    // When doing an inorder traversal of a tree, we left, then middle, then right. If this is a binary search tree, then
    // the inorder traversal will always be from lowest to highest.
    //
    // So while doing an inorder traversal, we can keep track of the last visited node. If the next visited node is greater than
    // or equal to the last visited node, then we continue. However, if at any point the next visited node is less than the
    // last visited node, we should return false.
    //
    
    private static int prev = Integer.MIN_VALUE;
    
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root == null) return true;
        
        if(!isBST(root.left)) return false;
        
        if(root.data <= prev) {
            return false;
        }
        prev = root.data;
        
        if(!isBST(root.right)) return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n0 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        n3.left = n1;
        n1.left = n0;
        n1.right = n2;
        n3.right = n4;
        n4.left = n5;
        System.out.println(ValidateBST.isBST(n3));
    }
    
}
