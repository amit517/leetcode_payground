fun main() {
    val arr: IntArray = intArrayOf(7,6,4,3,1)
    val solution = Solution()
    println(solution.maxProfit(arr))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        return if (prices.isNotEmpty()) {
            var buyPrice = prices[0]
            var sellPrice = 0
            for (i in prices.indices) {
                if (buyPrice > prices[i]) {
                    buyPrice = prices[i]
                    sellPrice = 0
                    continue
                }
                if (sellPrice < prices[i] && prices[i] > buyPrice) {
                    sellPrice = prices[i]
                }
            }
            if (sellPrice - buyPrice < 0) {
                0
            } else {
                sellPrice - buyPrice
            }
        } else {
            0
        }
    }
}