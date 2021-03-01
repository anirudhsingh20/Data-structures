package dynamicprogramming;

class BuyingAndSellingSharesOneTransaction {
    
    public static void main(String[] args) {
        
        int prices[] = {1,2,3,4,5}; // prices of share of each day
        findProfit(prices);
    }

    private static void findProfit(int prices[]) {

        int lsf = Integer.MAX_VALUE;  // least so far
        int pist = 0; // profit if sold today
        int op = 0;  // overall profit

        for(int i = 0 ; i<prices.length ; i++) {
            if(prices[i] < lsf) 
                lsf = prices[i];

            pist = prices[i] - lsf; 

            if(pist > op)
                op = pist;
        }

        System.out.println(op);
    }
}