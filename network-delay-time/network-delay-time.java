                {
                    int targetInfo = info.get(0); 
                    int distInfo = info.get(1); 
                    
                    if(distance.get(targetInfo) == null){
                        List<Integer> tmp = new LinkedList(); 
                        
                        tmp.add(targetInfo); 
                        //Add the distance of the original target
                        tmp.add(distInfo+dist); 
                        
                        queue.add(tmp); 
                    }
                }
            }
        }
        
        System.out.println("GRAPH : "+graph); 
        System.out.println("DISTANCE : "+distance); 
        
        if(distance.size() != N)
        {
            return -1; 
        }
        
        return answer; 
    }
}
