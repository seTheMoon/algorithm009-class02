/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new  HashMap();
        getIndex(inorder,map);
        return recursiveHelper(preorder,inorder,0,preorder.length-1,0,preorder.length-1,map);

    }

    public TreeNode recursiveHelper(int[] preorder,
                                int[] inorder,
                                int preLeft,
                                int preRight,
                                int inLeft,
                                int inRight,
                                Map<Integer,Integer> map) {

        if (preLeft > preRight) return null;

        int inorderRoot = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftNumber = inorderRoot - inLeft;

        root.left = recursiveHelper(preorder,
                                    inorder,
                                    preLeft+1,
                                    preLeft+leftNumber,
                                    inLeft,
                                    inorderRoot-1,
                                    map);
        root.right = recursiveHelper(preorder,
                                    inorder,
                                    preLeft+leftNumber+1,
                                    preRight,
                                    inorderRoot+1,
                                    inRight,
                                    map);

        return root;
    }

    public void getIndex(int[] inorder,Map<Integer,Integer> map) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
    }

}
// 第二遍
// 要用好二叉树的特性
// 前序遍历二叉树,第一个节点是根节点
// 中序遍历二叉树,中间的节点是根节点,根节点前面的节点都是左节点
