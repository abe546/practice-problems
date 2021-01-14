                emailRelationship.put(entryList.get(1), tmpSet); 
                
                emailToName.put(email, name); 
            }
            
            
        }
        
        HashSet<String> seen = new HashSet(); 
        List<List<String>> answer = new ArrayList(); 
        
        for(String email : emailRelationship.keySet())
        {
            if(!seen.contains(email))
            {
                List<String> components = new ArrayList();
                Stack<String> nodes = new Stack(); 
                
                nodes.push(email); 
              
                while(!nodes.isEmpty())
                {
                    for(String innerEmails : emailRelationship.get(nodes.pop()))
                    {
                        if(!seen.contains(innerEmails))
                        {
                            components.add(innerEmails);
                            nodes.push(innerEmails); 
                            seen.add(innerEmails); 
                        }
                    }
                }
                Collections.sort(components); 
                components.add(0, emailToName.get(email)); 
                answer.add(components); 
            }
        }
        
       
 
        
        return answer; 
    }
}
