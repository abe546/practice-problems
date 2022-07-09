/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    private Map<Integer, Employee> map = new HashMap<>(); 
    
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> idToEmployee = new HashMap(); 
        
        for(Employee emp : employees)
        {
            idToEmployee.put(emp.id, emp);
        }
        
        return importance(id, idToEmployee);
    }
    
    public int importance(int id, Map<Integer, Employee> map)
    {
        int currentId = id;
        Employee currentEmployee = map.get(id);
        int importance =  currentEmployee.importance;
        
        for(int sub : currentEmployee.subordinates)
        {
            importance+= importance(sub, map);
        }
        
        return importance;
    }
}