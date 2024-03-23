class SolutionV2 {
    /**
     * PROBLEM:
     * Have the function ArrayChallenge (strArr) take the array of strings stored in strarz, which will only contain two strings of equal length and return the Hamming distance between them. The Hamming distance is the number of positions where the corresponding characters are different. For example: if strArr is ["coder", "codec"] then your program should return 1. The string will always be of equal length and will only contain lowercase characters from the alphabet and numbers.
     *
     * Input type arrayOf("10011", "10100"))
     * output 3
     */

    fun ArrayChallange(stringArray: Array<String>): Int {
        val str1 = stringArray[0]
        val str2 = stringArray[1]
        var unmatchedString = 0

        for (i in str1.indices) {
            if ((str1[i] != str2[i])) {
                unmatchedString++
            }
        }
        return unmatchedString
    }

    fun LeetCode_1662_arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var sentence1 = ""
        var sentence2 = ""

        for (word in word1){
            sentence1 = sentence1.plus(word)
        }
        for (word in word2){
            sentence2 = sentence2.plus(word)
        }

        return sentence1 == sentence2
    }
}