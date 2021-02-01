/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private Map<Integer, Integer> employeeToImportanceMap = new HashMap();
    private Set<Integer> examined = new HashSet();
    
    public int getImportance(List<Employee> employees, int id) {
 
        //Extra step, in interview was already provided as a map under assumption
        Map<Integer, Integer> idToImportance = new HashMap(); 
        Map<Integer, Set<Integer>> idToSub = new HashMap(); 
        
        convertToMap(employees, idToImportance, idToSub);
        
        System.out.println("IMPORTANT : "+idToImportance); 
        System.out.println("ID TO SUB : "+idToSub); 
        
        for(int source : idToImportance.keySet())
        {
            if(!examined.contains(source))
            {
                findValue(source, idToImportance, idToSub);
            }
        }
        
 
        
        return employeeToImportanceMap.get(id); 
    }
    
    public int findValue(int source, Map<Integer, Integer> idToImportance, Map<Integer, Set<Integer>> idToSub)
    {
        if(examined.contains(source))
        {
            return employeeToImportanceMap.get(source);
        }
        
        if(idToSub.get(source) == null || idToSub.get(source).isEmpty())
        {
            examined.add(source);
            employeeToImportanceMap.put(source, idToImportance.get(source)); 
            
            return employeeToImportanceMap.get(source); 
        }
        
        for(int item : idToSub.get(source))
        {
            employeeToImportanceMap.put(
            source, employeeToImportanceMap.getOrDefault(source, 0)
            + findValue(item, idToImportance, idToSub));
        }
        
        examined.add(source); 
        
        employeeToImportanceMap.put(
        source, employeeToImportanceMap.getOrDefault(source, 0)+
        idToImportance.get(source)); 
        
        
        return employeeToImportanceMap.get(source); 
        
    }
    
    public void convertToMap(List<Employee> employees, Map<Integer, Integer> idToImportance, Map<Integer, Set<Integer>> idToSub)
    {
        for(Employee employee : employees)
        {
            int source = employee.id; 
            int value = employee.importance; 
            List<Integer> sub = employee.subordinates;
            
            Set<Integer> tmp = idToSub.getOrDefault(source, new HashSet<Integer>()); 
            tmp.addAll(sub); 
            idToSub.put(source, tmp); 
            idToImportance.put(source, value); 
        }
    }
 
}