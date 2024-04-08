import java.util.Stack

fun main() {
    val topicStack = TopicStack()

    println(topicStack.LC_150_evalRPN(arrayOf("2","1","+","3","*")))
}

class TopicStack {

    fun LC_150_evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (token in tokens) {
            if (token == "+") {
                val num1 = stack.pop()
                val num2 = stack.pop()
                stack.add(num1 + num2)
            } else if (token == "-") {
                val num1 = stack.pop()
                val num2 = stack.pop()
                stack.add(num2 - num1)
            } else if (token == "*") {
                val num1 = stack.pop()
                val num2 = stack.pop()
                stack.add(num1 * num2)
            } else if (token == "/") {
                val num1 = stack.pop()
                val num2 = stack.pop()
                stack.add((num2 / num1))
            } else{
                stack.add(token.toInt())
            }
        }

        return stack.pop()
    }
}

class LC_155_MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(`val`: Int) {
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
        stack.push(`val`)
    }

    fun pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop()
        }
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}