import java.util.Stack

fun main() {

}

class TopicStack {

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