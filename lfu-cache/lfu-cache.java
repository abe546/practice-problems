         if(itemAccessCount.get(b) == null)
         {
             System.out.println("A : "+a+" B : "+b); 
         }
         int bOccurr = itemAccessCount.get(b); 
         
         if(aOccurr == bOccurr)
         {
             //Evict oldest of the two (min heap on their time)
             long aTime = itemAccessedAtTime.get(a);
             long bTime = itemAccessedAtTime.get(b);
             
             return (int)(aTime - bTime);
         }
         
         return aOccurr - bOccurr; 
});
 
            if(!entries.isEmpty()){
          
                    
                
                
            itemAccessCount.remove(entries.get(0));
            itemAccessedAtTime.remove(entries.get(0));
            keyValue.remove(entries.get(0)); 
            
               
                
            entries.remove(entries.get(0)); 
    
       
            }
            
            keyValue.put(key, value); 
            entries.add(key);
            itemAccessCount.put(key, itemAccessCount.getOrDefault(key,0)+1);
            itemAccessedAtTime.put(key, monotonic++);
      
       
        }
    }
}
​
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
