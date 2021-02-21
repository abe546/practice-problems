import java.awt.*;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<TreeNode, Point> nodeToPoint = new HashMap();
    //TreeMap<Integer, Integer> test = new TreeMap(); 
    Map<Integer, List<TreeNode>> treeMap = new TreeMap();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<TreeNode>> packageList = new LinkedList();
        List<List<Integer>> valueList = new LinkedList();

        assignPoints(root, new Point(0, 0));

        traverse(root, treeMap);

        for (List<TreeNode> innerItem : treeMap.values()) {
            Collections.sort(innerItem, (a, b) ->
            {
                if (nodeToPoint.get(a).x == nodeToPoint.get(b).x) {
                    return a.val - b.val;
                }

                return nodeToPoint.get(a).x - nodeToPoint.get(b).x;
            });
            packageList.add(innerItem);
        }

        for (List<TreeNode> innerItem : packageList) {
            List<Integer> values = new LinkedList();

            for (TreeNode entry : innerItem) {
                values.add(entry.val);
            }

            valueList.add(values);
        }

        return valueList;
    }

    public void traverse(TreeNode root, Map<Integer, List<TreeNode>> treeMap) {
        if (root == null) {
            return;
        }

        int key = nodeToPoint.get(root).y;

        List<TreeNode> info = treeMap.getOrDefault(key, new LinkedList());

        info.add(root);
        treeMap.put(key, info);

        traverse(root.left, treeMap);
        traverse(root.right, treeMap);
    }

    public void assignPoints(TreeNode root, Point point) {
        if (root == null) {
            return;
        }

        nodeToPoint.put(root, point);

        assignPoints(root.left, new Point(point.x + 1, point.y - 1));
        assignPoints(root.right, new Point(point.x + 1, point.y + 1));
    }
}
