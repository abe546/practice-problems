        
        for(int i = 0; i < nums.length; i++)
        {
            if( i == index )
            {
                continue; 
            }
            
            if(ignoreDupe.contains(nums[i]))
            {
                continue; 
            }
            
            if(map.get(target - nums[i]) != null && map.get(target-nums[i]) != i && map.get(target-nums[i]) != index)
            { 
                
                List<Integer> list = new LinkedList();
                list.add(nums[index]);
                list.add(nums[i]);
                list.add(nums[map.get(target-nums[i])]);
                Collections.sort(list); 
                set.add(list); 
 
 
             
            }
        }
    }
}
