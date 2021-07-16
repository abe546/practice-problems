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
        
        if(root == null)
        {
            byte[] item = new String("null").getBytes(StandardCharsets.UTF_8);
            
            return Base64.getEncoder().encodeToString(item);
        }
        
        byte[] byteItem  = new String(String.valueOf(root.val)).getBytes(StandardCharsets.UTF_8);
            
            String actualItem = Base64.getEncoder().encodeToString(byteItem);
   
        
        return String.format("%s-%s-%s", actualItem, serialize(root.left), serialize(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] entries = data.split("-");
        List<String> list = new LinkedList(); 
        for(int i = 0; i < entries.length; i++)
        {
            String item = entries[i];
            list.add(new String(Base64.getDecoder().decode(item), StandardCharsets.UTF_8));
            System.out.println("CLONE : "+list.get(i)); 
        }
        
        TreeNode answer = construct(list.get(0), list);
        
        return answer; 
    }
    
    public TreeNode construct(String root, List<String> list)
    {
         if(list.get(0).equals("null"))
         {
             list.remove(0);
             return null;
         }
        
        TreeNode item = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0); 
        item.left = construct(list.get(0), list); 
        item.right = construct(list.get(0), list);
        
        return item;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));