package ch5.bitmanipulation.practice;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N
 * such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to
 * fit all of M. That is, if M= 10011, you can assume that there are at least 5 bits between j and i. You would not,
 * for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * 
 * @author Aditya Srinivasan
 *
 */
public class Insertion {

    // 
    // We are given some 32-bit numbers N and M and bit positions i and j where j > i. We must insert M into N starting
    // from bit j and ending at bit i
    //
    // Example:
    // N: 10010010110001001
    // M: 10101
    // j = 12, i = 8
    // Output: 1001*10101*10001001
    //
    // Example:
    // N: 11111111
    // M: 111
    // j = 6, i = 1
    // Output: 1*000111*1
    //
    // If the gap between j and i is more than the number of digits in M, then we just pad with zeros
    //
    // We can do this with bit manipulation
    //
    // Given N, let's clear all bits from j through i
    // This will set everything in our desired range to 0
    //
    // Then, we should M leftwards by i
    //
    // M is now aligned to start when N is cleared all to zeros
    // if we perform logical OR, then since M is being OR'd with zeros, it will be transferred over and "fill" that gap as desired
    //
    // so how do we clear bits from j through i
    // clear bits from j to 0 in num1
    // clear bits from MSB to i in num2
    // or both of these together, it will retrieve things from MSB to j and i to 0
    
    public static int insert(int N, int M, int i, int j) {
        int rightCleared = ((-1 << j) & N);
        int leftCleared = (((1 << i) - 1) & N);
        int clearedN = rightCleared | leftCleared;
        int shiftM = M << i;
        return clearedN | shiftM;
    }
    
    public static void main(String[] args) {
        String Nstring = "10000000000";
        String Mstring = "10011";
        int i = 2;
        int j = 6;
        int result = insert(Integer.parseUnsignedInt(Nstring, 2), Integer.parseUnsignedInt(Mstring, 2), i, j);
        System.out.println(Integer.toBinaryString(result));
    }

}
