package dynamicprogramming;

public class BuySellStockWithCoolDownInfiniteTransaction {
    
    public static void main(String[] args) {
        
        int prices[] =  {10,15,17,20,16,18,22,20,22,20,23,25};  // prices of stock each day
        findMaxProfit(prices);
    }

    private static void findMaxProfit(int[] prices) {

        int bsp = -prices[0]; // buy state profit
        int ssp = 0 ;         // sell state profit
        int csp = 0 ;         // cool down state profit

        for( int i = 1 ; i < prices.length ; i++) {
            int nbsp = 0 ;      // new buy state profit
            int nssp = 0 ;      // new sell state profit
            int ncsp = 0 ;      // new cool down state profit

            // compare new bsp with prev bsp
            if(csp - prices[i] > bsp) 
                nbsp = csp - prices[i];
            else 
                nbsp = bsp;

            // compare new ssp with prev ssp
            if(bsp + prices[i] > ssp)
                nssp = bsp + prices[i];
            else 
                nssp = ssp;

            // compare csp with new cssp
            if(ssp > csp)
                ncsp = ssp;
            else 
                ncsp = csp;

            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;

            // System.out.println(bsp + " " + ssp + " " + csp);
        }

        // int maxProfit = ssp > csp ? ssp : csp;

        System.out.println(ssp);
    }
}
