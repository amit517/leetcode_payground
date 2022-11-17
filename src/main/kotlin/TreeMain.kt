import kotlin.math.max

fun main() {
    var a = TreeNode(1)
    var b = TreeNode(12)
    var c = TreeNode(2)
    var d = TreeNode(15)
    var e = TreeNode(7)

    a.left = b
    a.right = c
    c.left = d
    c.right = e

   /* b.left = null
    b.right = c*/

    println(inorderTraversal(a))
}

fun inorderTraversal(root: TreeNode?, list : List<Int>? = null): List<Int> {
    if(root == null) return list ?: emptyList()

    var mutableList = mutableListOf<Int>()
    var left = inorderTraversal(root.left,list)
    var right = inorderTraversal(root.right,list)

    mutableList.addAll(left)
    mutableList.add(root.`val`)
    mutableList.addAll(right)

    return mutableList
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (q == null || p == null) return false
    if (p.`val` != q.`val`) return false

    return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return (1 + max(maxDepth(root.left), maxDepth(root.right)))
}