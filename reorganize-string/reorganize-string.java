            if(frequency > 1)
            {
                Character entry = queue.peek(); 
                
                int complement =0; 
                
                if(entry != null){
                 complement = charOccurrence.get(queue.peek());
                }
 
                 System.out.println("COMPLEMENT : "+complement);
                    System.out.println("FREQUENCY : "+frequency+" ENTRY : "+ mostFrequentChar); 
                
                while(entry != null && (  complement == frequency-1 || complement < frequency))
                {
                    set.add(queue.poll()); 
                    if(queue.peek() == null)
                    {
                        break;
                    }
                    complement += charOccurrence.get(queue.peek());
                }
                
                if(complement == frequency)
                {
                    set.add(queue.poll()); 
                }
                
                if(!(complement >= frequency-1))
                {  System.out.println("COMPLEMENT : "+complement);
                    System.out.println("FREQUENCY : "+frequency+" ENTRY : "+ mostFrequentChar); 
                   
                    return "";
                } 
            } 
            
        }
        
        //Add chars back to priority queue to be used to construct String
        for(char entry : characters)
        {
            queue.add(entry); 
        }
        
      return createString(set, charOccurrence, queue); 
        
    }
    
