package dynamicprogramming;

//  2 transaction must not overlap ex. buy buy sell sell   X (incorrect transaction)
//                                     buy sell buy sell  (correct)


public class BuySellStocksInfiniteTransaction {
    
    public static void main(String[] args) {
        
        int prices[] = { 1,2,3,4,5};  // prices of stocks each day
        findMaxProfit(prices);
    }

    private static void findMaxProfit(int[] prices) {

        int bd = 0 ; // buying day
        int sd = 0 ; // selling day
        int profit = 0; 

        for( int i = 1 ; i< prices.length; i++) 
        {
            if(prices[i] > prices[i-1]) 
            {
                sd++;
            }
            else 
            {
                profit += prices[sd] - prices[bd];
                sd = bd = i;
            }
        }

        profit += prices[sd] - prices[bd];  // last transaction

        System.out.println(profit);
    }
}
