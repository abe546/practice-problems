class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> answer = new LinkedList(); 
        StringBuilder stringBuilder = new StringBuilder(); 
        
        for(String word : words)
        {
             if(stringBuilder.length() + (word.length()) > maxWidth)
            {
              answer.add(packageString(stringBuilder, maxWidth)); 
              stringBuilder = new StringBuilder();
                 
            }
            
            stringBuilder.append(String.format("%s ",word));
        }
        
        if(stringBuilder != null && stringBuilder.length() > 0)
        {
            answer.add(packageString(stringBuilder, maxWidth));
        }
        
        answer.set(answer.size()-1, packageLast(answer.get(answer.size()-1), maxWidth));
        
        return answer;
    }
    
    public String packageLast(String word, int maxWidth)
    {
        String workItem = word.toString(); 
        String[] workArr = workItem.split("\\s+"); 
        
        StringBuilder stringBuilder = new StringBuilder(); 
        
        for(int i =0; i < workArr.length; i++)
        {
            String entry = workArr[i];
            if(i < workArr.length -1){
            stringBuilder.append(entry+" "); 
            }else
            {
                stringBuilder.append(entry); 
            }
        }
        
        while(stringBuilder.length() < maxWidth)
        {
            stringBuilder.append(' '); 
        }
        
        return stringBuilder.toString(); 
    }
    
    public String packageString(StringBuilder input, int maxWidth)
    {
        String workItem = input.toString(); 
        String[] workArr = workItem.split("\\s+"); 
        
        int amount = input.length() - workArr.length; //Subtract number of spaces
        
        while(amount < maxWidth)
        {
            workArr[0] = workArr[0]+" "; 
            amount++; 
            
            for(int i = 1; i < workArr.length; i++)
            {
                 if(amount == maxWidth)
                {
                    System.out.println("BREAKING : "+amount); 
                    break;
                }
                
                 System.out.println("AMOUNT : "+amount);
                System.out.println("I : "+i); 
                if(i == workArr.length -1)
                {
                    System.out.println("LENGTH : "+workArr.length); 
                    continue; 
                }
               
                workArr[i] = workArr[i] + " "; 
                amount++; 
                
               
            }
        }
        
        input = new StringBuilder(); 
        
        for(String entry : workArr)
        {
            input.append(entry);
        }
         
        
        return input.toString(); 
    }
    
    
}