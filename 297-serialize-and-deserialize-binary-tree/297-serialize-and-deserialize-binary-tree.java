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
        
        System.out.println("ANSWER : "+answer); 
        
        return Base64.getEncoder().encodeToString(answer.getBytes(StandardCharsets.UTF_8));
    }
    
    public String packageString(TreeNode root)
    {
        if(root == null)
        {
            return "null";
        }
             
        return String.format("%s %s %s", root.val, packageString(root.left), packageString(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = new String(Base64.getDecoder().decode(data), StandardCharsets.UTF_8);
        System.out.println("DATA : "+data); 
        String[] entries = data.split("\\s+");
        List<String> list = new LinkedList(); 
        for(int i = 0; i < entries.length; i++)
        { 
            list.add(entries[i]);
           // System.out.println("CLONE : "+list.get(i)); 
        }
        
        TreeNode answer = construct(list);
        
        return answer; 
    }
    
    public TreeNode construct( List<String> list)
    {
         if(list.get(0).equals("null"))
         {
             list.remove(0);
             return null;
         }
        
        TreeNode item = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0); 
        item.left = construct( list); 
        item.right = construct( list);
        
        return item;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));