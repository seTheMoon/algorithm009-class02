### 第 13 课
+ 字典树 Trie 树
    + 字典树的数据结构
        + 字典树,即 Trie 树,又称单词查找树或键树,是一种树形结构.典型应用是用于统计和排序大量的字符串(但不仅限于字符串),所以经常被搜索引擎系统用于文本词频统计.
        + 他的优点是:最大限度的减少无谓的字符串比较,查询效率比哈希表高
    + 字典树的核心思想
        + Trie 树的核心思想是空间换时间
        + 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
    + 字典树的性质
        + 节点本身不存完整单词
        + 从根节点到某一节点,路径上经过的字符连接起来,为该节点对应的字符串
        + 每个节点的所有子节点路径代表的字符都不相同
+ 并查集
```
class UnionFind { 
    private int count = 0; 
    private int[] parent; 
    public UnionFind(int n) { 
        count = n; 
        parent = new int[n]; 
        for (int i = 0; i < n; i++) { 
            parent[i] = i;
        }
    } 
    public int find(int p) { 
        while (p != parent[p]) { 
            parent[p] = parent[parent[p]]; 
            p = parent[p]; // 压缩
        }
        return p; 
    }
    public void union(int p, int q) { 
        int rootP = find(p); 
        int rootQ = find(q); 
        if (rootP == rootQ) return; 
        parent[rootP] = rootQ; 
        count--;
    }
}
```

+ 单词搜索II
    + 时间复杂度 O(M(4*3^(L-1)))


### 第 14 课
+ 剪枝的实现和特性
    + 朴素搜索
        + 傻搜索
    + 优化方式
        + 不重复(fibonacci)
        + 剪枝(生成括号问题)
            + 如果发现这个分支是已经处理过的,就暂存在缓存里面
            + 减掉较差的分支或次优的分支
     + 搜索方向
        + DFS 深度优先
        + BFS 广度优先
        + 双向搜索(双向 BFS)
        + 启发式搜索
            + 先搜索优先级高的
            + 估价函数
                + 启发式函数:h(n),他用来评价哪些节点最有希望的事一个我们要找的节点,h(n)会返回一个非负实数,也可以认为是 从节点 n 的目标节点路径的估价成本
                + 启发式函数是一种告知搜索方向的方法.他提供了一种明智的方法来猜测哪个邻居节点会导向一个目标
        + 双向 BFS 模板:
```
public class BFS_Two {

    public List<List<Integer>> bfs(TreeNode begin,TreeNode end) {

        Queue<TreeNode> beginQueue = new ArrayDeque<>();
        Queue<TreeNode> endQueue = new ArrayDeque<>();
        List<List<Integer>> res = new LinkedList<>();

        beginQueue.add(begin);
        endQueue.add(end);

        while(!beginQueue.isEmpty() && !endQueue.isEmpty()) {

            if (beginQueue.size() > endQueue.size()) {
                Queue<TreeNode> tmp = beginQueue;
                beginQueue = endQueue;
                endQueue = tmp;
            }

            int size = beginQueue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = beginQueue.poll();
                tmp.add(node.val);
                if (null != node.left) beginQueue.add(node.left);
                if (null != node.right) beginQueue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
```
+ 回溯
    + 回溯法采用试错的思想,他尝试分步的去解决一个问题(其实就是分治+试错).在分步解决问题的过程中,当他通过尝试发现现有的分步答案不能得到有效的正确的解答的时候,他将取消上一步甚至是上几步的计算,再通过其他的可能的分步解答再次尝试寻找问题的答案
    + 回溯法通常用最简单的递归方法来实现,在反复重复上述的步骤后可能出现两种情况:
        + 找到一个可能存在的正确的答案
        + 在尝试了所有可能的分步方法后宣告该问题没有答案
    + 在最坏的情况下,回溯法会导致一次复杂度为指数时间的计算
    + 一看到搜索问题,就应该立即想到树形结构