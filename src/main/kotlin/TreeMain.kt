import kotlin.math.max

fun main() {
    var a = TreeNode(3)
    var b = TreeNode(9)
    var c = TreeNode(20)
    var d = TreeNode(15)
    var e = TreeNode(7)

    a.left = b
    a.right = c
    c.left = d
    c.right = e

    println(maxDepth(a))
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return (1 + max(maxDepth(root.left), maxDepth(root.right)))
}