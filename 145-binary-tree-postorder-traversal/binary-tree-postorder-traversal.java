class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            ans.add(node.val);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }

        Collections.reverse(ans);

        return ans;
    }
}