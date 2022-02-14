class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products); 
        
        List<List<String>> list = new LinkedList(); 
        int start = 0; 
        
        String searchItem = null; 
        for(int i=0; i< searchWord.length();i++)
        {
            searchItem = searchWord.substring(0, i+1);  
            List<String> tmp = new LinkedList(); 
            
            for(int j=start; j<products.length; j++)
            {   
               
                if(products[j].startsWith(searchItem))
                {
                if(tmp.size() == 3)
                {
                    break; 
                }
                    
                    tmp.add(products[j]);  
                } 
            }
          
                list.add(tmp); 
           
        }
        
        return list; 
        
    }
}