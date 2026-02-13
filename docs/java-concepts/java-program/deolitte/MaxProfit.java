// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class MaxProfit {
  public static int maxProfit(int[] prices) {
        // Edge case: if the array is empty or has only one price, no profit can be made
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;  // To store the minimum price encountered so far
        int maxProfit = 0;  // To store the maximum profit
        // Traverse through the array of prices
        for (int price : prices) {
            // Update the minPrice if we find a lower price
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit if selling at current price
            int potentialProfit = price - minPrice;
            // Update maxProfit if the potential profit is greater
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        System.out.println("Maximum Profit (Example 1): " + maxProfit(prices1));  // Output: 6

        // Example 2
        int[] prices2 = {10, 8, 7, 5, 2};
        System.out.println("Maximum Profit (Example 2): " + maxProfit(prices2));  // Output: 0
    }
}
