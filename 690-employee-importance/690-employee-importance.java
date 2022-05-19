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
        
        int importance = 0; 
        Employee pointer = null; 
        for(Employee employee : employees)
        {
            if(employee.id == id)
            {
                pointer = employee;
            }
            
            map.put(employee.id, employee);
        }
        
        
        return getImportance(pointer);
    }
    
    public int getImportance(Employee employee)
    {
        int importance = employee.importance;
        
        for(int employeeId : employee.subordinates)
        {
            if(map.get(employeeId) != null){
            importance += getImportance(map.get(employeeId));
            }
        }
        
        return importance;
    }
}