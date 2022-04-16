import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int curr = 0; 
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String answer = packageString(root); 
        
        //System.out.println("ANSWER : "+answer); 
        
        return Base64.getEncoder().encodeToString(answer.getBytes(StandardCharsets.UTF_8));
    }
    
    public String packageString(TreeNode root)
    {
        StringBuilder sb = new StringBuilder(); 
         
        if(root == null)
        {
            return "null";
        }
        
        Stack<TreeNode> stack = new Stack<>(); 
        
        stack.add(root); 
        
        while(!stack.isEmpty()){
            TreeNode value = stack.pop(); 
            
            if(value == null)
            {
                sb.append("null "); 
                continue; 
            }
            
            sb.append(value.val + " "); 
            
                       stack.add(value.left); 
            stack.add(value.right); 
 
        }
             
        return sb.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = new String(Base64.getDecoder().decode(data), StandardCharsets.UTF_8);
      //  System.out.println("DATA : "+data); 
        String[] entries = data.split("\\s+");
        Queue<Integer> queue = new LinkedList(); 
        for(int i = 0; i < entries.length; i++)
        { 
            if(entries[i].equals("null"))
            {
                queue.add(null);
                continue; 
            }
            queue.add(Integer.valueOf(entries[i]));
           // System.out.println("CLONE : "+list.get(i)); 
        }
        
        TreeNode answer = construct(queue);
        
        return answer; 
    }
    
    public TreeNode construct( Queue<Integer> que)
    { 
        Integer current = que.poll(); 
        
        if(current == null)
        {
            return null; 
        }
        
        TreeNode head = new TreeNode(current); 
     
        head.right = construct(que); 
           head.left = construct(que); 
        
        return head; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));