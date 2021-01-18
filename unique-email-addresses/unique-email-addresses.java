class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> emailsSet = new HashSet();
        int count = 0; 
        for(String entry : emails)
        {
            String [] arr = entry.split("@"); 
            String localName = arr[0]; 
            String domain = arr[1]; 
            
            System.out.println("LOCAL : "+localName + " DOMAIN : "+domain); 
            
            if(!emailsSet.contains(String.format("%s@%s", sanitizedName(localName), domain)))
            {
              count++;
                emailsSet.add(String.format("%s@%s", sanitizedName(localName), domain));
            }
               
        }
               
       return count; 
        
    }
        
    public String sanitizedName(String localName)
    {
        StringBuilder stringBuilder = new StringBuilder(); 
