package bitManipulation;

import java.util.*;

public class OperationOnAParticularBit {

  // QUESTION:
  // 1. You are given a number n.
  // 2. Print the number produced on setting its i-th bit.
  // 3. Print the number produced on unsetting its j-th bit.
  // 4. Print the number produced on toggling its k-th bit.
  // 5. Also, Check if its m-th bit is on or off. Print 'true' if it is on,
  // otherwise print 'false'.

  public static void main(String[] args) {

    // INPUT:
    // 57
    // 3
    // 3
    // 3
    // 3

    // OUTPUT:
    // 57
    // 49
    // 49
    // true
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    scn.close();

    // write your code here
    int onMask = (1 << i);
    int offMask = (~(1 << j));
    int toggleMask = (1 << k);
    int checkMask = (1 << m);

    System.out.println((n | onMask));
    System.out.println((n & offMask));
    System.out.println((n ^ toggleMask));
    System.out.println((n & checkMask) == 0 ? false : true);
  }

}
