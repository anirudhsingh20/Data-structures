package recursion2;

import java.util.*;

public class PrintAbbreviations {

    public static void solution(String str, String asf, int count, int pos) {
        // write your code here
        if (pos == str.length()) {
            if (count > 0) {
                System.out.println(asf + count);
            } else {
                System.out.println(asf);
            }
            return;
        }

        if (count > 0) {
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        } else {
            solution(str, asf + str.charAt(pos), 0, pos + 1);
        }
        solution(str, asf, count + 1, pos + 1);

    }

    public static void main(String[] args) {

        // INPUT:
        // pep

        // OUTPUT:
        // pep
        // pep
        // pe1
        // p1p
        // p2
        // 1ep
        // 1e1
        // 2p
        // 3

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0, 0);
        scn.close();
    }

}