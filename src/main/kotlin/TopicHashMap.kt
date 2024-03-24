fun main() {
    val hashMap = TopicHashMap()
}

class TopicHashMap {

    fun LC_1_twoSum(nums: IntArray, target: Int): IntArray {
        val prevHashMap = HashMap<Int, Int>()

        for ((index, value) in nums.withIndex()) {
            val diff = target - value
            if (prevHashMap.containsKey(diff)) return intArrayOf(prevHashMap[diff]!!, index)
            else prevHashMap[value] = index
        }

        return intArrayOf()
    }

}