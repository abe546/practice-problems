/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Set<Integer> avoid = new HashSet(); 
    public Node cloneGraph(Node node) {
        
        if(node == null)
        {
            return null; 
        }
        
        Node head = new Node(node.val);
        head.neighbors = null; 
        
        setNeighbors(node, head);
 
        return head; 
    }
    
    /**
    * Given node and pointer, define pointer value as node value.
    * Then, for all children of node, do same thing, with other pointer. Then, add other pointer as neighbor of origianl
    */
    Map<Node, Node> oldToNew = new HashMap(); 
    public void setNeighbors(Node node, Node pointer)
    {
        if(node == null)
        {
            return;
        }
        
        if(oldToNew.containsKey(node))
        {
            return;
        }
        
        oldToNew.put(node, pointer); 
        
        pointer.val = node.val; 
        pointer.neighbors = new ArrayList<Node>();
        
        for(Node child : node.neighbors)
        {
            Node newPointer = new Node(child.val);
            
            if(oldToNew.get(child) != null)
            {
                newPointer = oldToNew.get(child);
            }
            
            setNeighbors(child, newPointer);
            
            pointer.neighbors.add(newPointer); 
        }
        
         
    }
}