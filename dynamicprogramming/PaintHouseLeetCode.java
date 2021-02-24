package dynamicprogramming;

public class PaintHouseLeetCode {
    
    public static void main(String[] args) {
        
        int noOfHouse = 4;

        int costOfColors[][]= {
            {1, 5, 7},
            {5, 8, 4},
            {3, 2, 9},
            {1, 2, 4}
        };
        minCostToPaintAllHouse(costOfColors, noOfHouse);
    }

    private static void minCostToPaintAllHouse(int[][] cost, int noOfHouse) {

        int red = cost[0][0];
        int green = cost[0][1];
        int blue = cost[0][2];

        for(int i = 1 ; i<cost.length; i++) {
            
            int prevRed = red;
            int prevGreen = green;
            int prevBlue = blue;

            red = cost[i][0] + Math.min(prevBlue,prevGreen);
            green = cost[i][1] + Math.min(prevBlue, prevRed);
            blue = cost[i][2] + Math.min(prevRed, prevGreen);
            
        }
        int minCost = Math.min(Math.min(red, blue), green);

        System.out.println(minCost); // min cost to paint each house such that no 2 adjacent house have same color
    }
}
