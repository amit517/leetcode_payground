fun main() {
    val arr: IntArray = intArrayOf(7,6,4,3,1)
    val solution = Solution()
    println(solution.maxProfit(arr))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var lowestBuyPrice = Int.MAX_VALUE
        var overAllProfit = 0

        for (i in prices.indices) {
            if (prices[i] < lowestBuyPrice){
                lowestBuyPrice = prices[i]
            }
            if (overAllProfit <  prices[i] - lowestBuyPrice){
                overAllProfit = prices[i] - lowestBuyPrice
            }
        }

        return overAllProfit
    }
}