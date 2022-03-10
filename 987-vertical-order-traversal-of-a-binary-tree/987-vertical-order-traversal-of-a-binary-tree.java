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
    Map<Integer, List<TreeNode>> treeMap = new TreeMap();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> packageList = new LinkedList(); 
        
        assignPoints(root, new Point(0,0)); 
        traverse(root, treeMap); 
        
        for(List<TreeNode> innerList : treeMap.values())
        {
            Collections.sort(innerList, (a,b) ->
                             {
                                 if(nodeToPoint.get(a).x == nodeToPoint.get(b).x)
                                 {
                                     return a.val - b.val; 
                                 }
                                 
                                return nodeToPoint.get(a).x - nodeToPoint.get(b).x;  
                             });
            
            List<Integer> innerPackage = new LinkedList(); 
            
            for(TreeNode item : innerList)
            {
                innerPackage.add(item.val);
            }
            
            packageList.add(innerPackage); 
            
            
        }
        
        return packageList; 
      
    }
    
    /**
    * Traverse the tree and for every column i keep track of nodes in said column (using list to categorize values)
    */
    public void traverse(TreeNode root, Map<Integer, List<TreeNode>> treeMap)
    {
        if(root == null)
        {
            return;
        }
        
        List<TreeNode> getInfo = treeMap.getOrDefault(nodeToPoint.get(root).y, new LinkedList()); 
        getInfo.add(root);
        
        treeMap.put(nodeToPoint.get(root).y, getInfo); 
        
        traverse(root.left, treeMap); 
        traverse(root.right, treeMap); 
        
    }
    
    /**
    * Go through tree and assign respective point (x,y) to each node using 
    hashmap to store the relationship
    */
    public void assignPoints(TreeNode root, Point point)
    {
        if(root == null)
        {
            return;
        }
        
        nodeToPoint.put(root, point); 
        
        assignPoints(root.left, new Point(point.x+1, point.y-1));
        assignPoints(root.right, new Point(point.x+1, point.y+1));
    }

}
