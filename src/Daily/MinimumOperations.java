package Daily;

import java.util.*;

public class MinimumOperations {
    static int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSwap = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelValues = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            totalSwap+=swap(levelValues);
        }
        return  totalSwap;
    }
    static int swap(int[] nums) {
        int[] sorted = Arrays.stream(nums.clone()).sorted().toArray();
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                cnt++;

                int corPos = map.get(sorted[i]);
                nums[corPos] = nums[i];
                map.put(nums[i],corPos );
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Integer[] root = {1,4,3,7,6,8,5,null,null,null,null,9,null,10};
        Tree tree = new Tree(root);
        System.out.println(minimumOperations(tree.root));
    }
}
