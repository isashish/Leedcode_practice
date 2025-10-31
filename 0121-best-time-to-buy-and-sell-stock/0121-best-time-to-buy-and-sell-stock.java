class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
      
        for(int price : prices){

            // Find the lowest price
            if(price < minPrice){
                minPrice = price;
            } 
            // Calculate the profit if sold today
            else if(price - minPrice > maxPrice){
                maxPrice = price - minPrice;
            }
           
        }
        return maxPrice;
        
    }
}