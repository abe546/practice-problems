            }
            
            tmp.add(root.val);
            if(answer.size() > level){
            answer.set(level, tmp); 
            }else
            {
                answer.add(tmp); 
            }
            
        }else if(level % 2 != 0)
        {
            //If we are odd we want to add elements to the list by continually setting the
            // first entry
             List<Integer> tmp = new ArrayList(); 
            
            if(answer.size() > level)
            {
                //We've been to this level before, go get the previous items
                tmp = answer.get(level); 
            }
            
            tmp.add(0, root.val); 
            
            if(answer.size() > level){
            answer.set(level, tmp); 
            }else
            {
                answer.add(tmp); 
            }
            
        }
        
        createZigZagList(answer, root.left, level+1);
        createZigZagList(answer, root.right, level+1); 
    }
}
