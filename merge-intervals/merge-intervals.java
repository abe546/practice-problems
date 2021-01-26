        int[][] answer = null; 
        
        if(queue.size() == 1)
        {
            answer = new int[1][2]; 
            answer[0] = queue.poll(); 
            
            return answer; 
        }
        
        int[] arr = queue.poll();
        List<int[]> listOfArrays = new LinkedList(); 
                
        while(!queue.isEmpty()){
     
            int[] tmp = queue.poll(); 
            
            int start = arr[0];
            int end = arr[1]; 
            int otherStart = tmp[0]; 
            int otherEnd = tmp[1]; 
            
            if(( end >= otherStart && end <= otherEnd ) || (otherEnd >= start && otherEnd <= end))
            { 
                
                arr[0] = Math.min(start, otherStart); 
                arr[1] = Math.max(end, otherEnd); 
         
            }else
            {
                int[] cloneA = {arr[0], arr[1]};
                listOfArrays.add(cloneA); 
                
                arr[0] = tmp[0]; 
                arr[1] = tmp[1]; 
            }
            
            if(queue.isEmpty())
            {
                listOfArrays.add(arr); 
            }
            
        }
 
        
        answer = new int[listOfArrays.size()][2]; 
        
        int k = 0; 
        for(int[] entry : listOfArrays)
        {
            answer[k++] = entry;
        }
        
        return answer; 
