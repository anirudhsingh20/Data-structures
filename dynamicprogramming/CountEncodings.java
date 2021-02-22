package dynamicprogramming;

public class CountEncodings {

    public static void main(String[] args) {

        String str = "21123";
        countEncodings(str);

    }

    public static void countEncodings(String str) {

        int dp[] = new int[str.length()];

        dp[0] = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {

                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                }
                else {
                    dp[i] = 0;
                }
            } else {

                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        // for (int a : dp)
        //     System.out.println(a);

        System.out.println(dp[str.length() - 1] + " -> no. of total encodings");
    }
}
