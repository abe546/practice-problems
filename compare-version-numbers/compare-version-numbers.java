class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] vers1 = version1.split("\\."); 
        String[] vers2 = version2.split("\\.");
        
        int max = Math.max(vers1.length, vers2.length); 
        
        int i = 0; 
        int j = 0; 
        
        while(j < max || i < max)
        {
            int item1 = 0; 
            int item2 = 0; 
            
            //System.out.println("MAX : "+max); 
            //System.out.println("J : "+j); 
           // System.out.println("I : "+i); 
            
            if(i < vers1.length)
            {
                item1 = Integer.valueOf(vers1[i]);
                i++;
            }else
            {
                i++; 
            }
            
            if(j < vers2.length)
            {
                item2 = Integer.valueOf(vers2[j]);
                j++;
            }else
            {
                j++; 
            }
            
            if(item1 < item2)
            {
                return -1;
            }
            
            if(item2 < item1)
            {
                return 1; 
            }
            
           //System.out.println("ITEM 1 : "+item1); 
           //System.out.println("ITEM 2 : "+item2); 
        }
        
        return 0; 
    }
}