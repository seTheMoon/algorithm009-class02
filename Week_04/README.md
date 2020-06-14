学习笔记

### 第 9 课
+ 深度优先搜索、广度优先搜索的实现和特性
   + 搜索-遍历的时候要保证
   + 每个节点都要保证一次
   + 且仅访问一次
   + 按照节点的访问顺序不同分为
      + 深度优先:depth first search (中序遍历)
      + 广度优先:breadth first search(层序遍历)
```
// 深度优先
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        recursiveHelper(root,res);
        return res;
    }
    public void recursiveHelper(TreeNode root,List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                recursiveHelper(root.left,res);
            }
            res.add(root.val);
            if (root.right != null) {
                recursiveHelper(root.right,res);
            }
        }
    }
}

// 广度优先
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
​
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
​
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
```

 + 括号生成
   + 我们的解法也是深度优先搜索(每一个状态都可以分叉出来左括号和右括号,都是每一个分支走到底之后再走下一个分支)
 + 岛屿数量
   + 解法:https://leetcode-cn.com/problems/number-of-islands/
   + 感觉就是递归
### 第 10 课
 + 贪心算法
   + 在每一步都选择局部最优解,从而希望得到全局最优解
   + 与动态规划的区别
        + 贪心算法对每个子问题做出选择后不能回退
      + 动态规划可以保存以前的运算结果,并根据以前的结果对当前进行选择,有 回退功能
   + 适用贪心算法的情况
      + 问题能分成子问题解决,子问题的最优解能递推到最终问题的最优解
 + 零钱兑换
   + 解法:http://https//leetcode-cn.com/problems/coin-change/submissions/
   + 里面 for 循环的作用是:
      + 先计算出来面值最大的需要多少个,一层一层下探,如果最终无法找零,则利用 for 循环,使面值最大的个数减去 1,再接着下探
 + 买卖股票的最佳时机 ii
   + 解法:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
   + 用到了贪心的思想,如果第二天比前一天高则可以卖,相当于只遍历一次,时间复杂度为 O(N)
 + 跳跃游戏
   + 解法:https://leetcode-cn.com/problems/jump-game/
   + 可以使用很多种方法,但最简单的还是贪心算法
      + 这个解法值得学习的地方在于,比较巧妙的找到了切入方法,从最后往前倒序遍历,设置一个标志位作为能到达的 index,如果能到达则更新标志位
 ### 第 11 课
 + 二分查找
   + 二分查找的前提
      + 目标函数单调递增或递减
      + 存在上下界
      + 能够通过索引访问
   + 二分查找模版
```
left, right = 0, len(array) - 1 
while left <= right: 
      mid = (left + right) / 2 
      if array[mid] == target: 
            # find the target!! 
            break or return result 
      elif array[mid] < target: 
            left = mid + 1 
      else: 
            right = mid - 1
```
 + x的平方根
   + 题解:https://leetcode-cn.com/problems/sqrtx/submissions/
   + 可以使用二分查找,但时间复杂度为 O()不是最优,一般工业界都使用牛顿迭代法
```
class Solution {
    public int mySqrt(int x) {
​
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
```
 + 有效的完全平方数
   + 题解:https://leetcode-cn.com/problems/valid-perfect-square/
   + 和 上一题类似,可以使用牛顿迭代法计算
 + 搜索排序旋转数组
   + 题解:https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
   + 题中要求时间复杂度为 O(logn),则一般情况下都是二分法
   + 数组是发生过旋转的,在整体上不符合单调性,但局部仍然复合单调性.每一次都二分,判断出前一半是否单调,判断出应该向后规约还是向前规约