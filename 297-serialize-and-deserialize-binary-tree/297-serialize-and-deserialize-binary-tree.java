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
 
    private static final String DELIMETER = ":"; 
    private static final String NULL = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String packagedString = packageString(root);
        
        Base64.Encoder encoder = Base64.getEncoder();
    
        
        return encoder.encodeToString(packagedString.getBytes());
    }
    
    // Convert tree to String format. Traverse in order, use space as delimeter
    public String packageString(TreeNode root)
    {
        if(root == null)
        {
            return NULL; 
        }
        
        Stack<TreeNode> stack = new Stack(); 
        StringBuilder sb = new StringBuilder(); 
        
        stack.add(root);
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop(); 
            
            sb.append(formatEntry(current));
            
            if(current == null)
            {
                continue;
            }
            
            stack.add(current.right); 
            stack.add(current.left); 
        }
        
        return sb.toString().substring(0, sb.length()-1);
    }
    
    public String formatEntry(TreeNode item)
    {
        if(item == null)
        {
            return String.format("%s%s", NULL, DELIMETER);
        }
        
        return String.format("%s%s", item.val, DELIMETER); 
    }
 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Base64.Decoder decoder = Base64.getDecoder();
        
        String unpacked = new String(decoder.decode(data));
 
        
        Queue<Integer> que = new LinkedList(); 
        
        for(String item : unpacked.split(DELIMETER))
        {
           if(item.equals(NULL))
           {
               que.add(null);
               continue;
           }
            
           que.add(Integer.valueOf(item)); 
        }
        
        TreeNode root = construct(que); 
        
      return root; 
    }
    
    public TreeNode construct(Queue<Integer> que)
    {
        Integer current = que.poll(); 
        
        if(current == null)
        {
            return null; 
        }
        
        TreeNode item = new TreeNode(current); 
        item.left = construct(que); 
        item.right = construct(que); 
        
        return item; 
    }
 
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));