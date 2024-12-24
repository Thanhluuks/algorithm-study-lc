package Daily;

public class ReverseOddLevels {
    static TreeNode reverseOddLevels(TreeNode root) {
        traverseDFS(root.right,root.left, 0);
        return root;
    }

    private static void traverseDFS(TreeNode right,TreeNode left, int i) {
        if (left == null || right == null) return;
        if (i %2 == 0) {
                int tem = right.val;
                right.val = left.val;
                left.val = tem;
            }
        traverseDFS(left.left,right.right,i+1);
        traverseDFS(left.right,right.left,i+1);
    }

    public static void main(String[] args) {
        Integer[] nodes = {2,3,5,8,13,21,34};
        Tree tree = new Tree(nodes);
        tree.printTreeByLevel();
        System.out.println("******************");
        TreeNode root = tree.root;
        TreeNode res = reverseOddLevels(root);
        Tree newTree = new Tree();
        newTree.root =res;
        newTree.printTreeByLevel();

    }
}
