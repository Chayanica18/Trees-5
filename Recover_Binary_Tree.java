
//TC: o(n)
//Space:o(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root.left);
        if(prev != null && prev.val >= root.val)
        {
            if(second == null && first == null)
            {
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
            
        }
        prev = root;
        inorder(root.right);

    }
}
