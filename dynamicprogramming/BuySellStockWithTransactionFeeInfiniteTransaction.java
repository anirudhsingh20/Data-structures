package dynamicprogramming;

public class BuySellStockWithTransactionFeeInfiniteTransaction {
    
    public static void main(String[] args) {
     
        int prices[] =  {10,15,17,20,16,18,22,20,22,20,23,25};  // prices of stock each day
        int transactionFee = 3;  // selling fee 3
        findMaxProfit(prices, transactionFee);
    }

    private static void findMaxProfit(int[] prices, int transactionFee) {

        int bsp = - prices[0]; // buying state profit
        int ssp = 0;           // sell state profit

        for(int i = 1 ; i < prices.length; i++) {

            int nbsp = 0;
            int nssp = 0;

            // compare new buy state profit with previous buy state profit
            if(ssp - prices[i] > bsp) {
                nbsp = ssp - prices[i];
            }
            else {
                nbsp = bsp;
            }
            
            // compare new sell state profit with previous sell state profit
            if(prices[i] - transactionFee + bsp > ssp) {
                nssp = prices[i] - transactionFee  + bsp;
            }
            else {
                nssp = ssp;
            }

            ssp = nssp;
            bsp = nbsp;
            // System.out.println(bsp + " " + ssp);
        }

        System.out.println(ssp); // print final sell state profit
    }
}
