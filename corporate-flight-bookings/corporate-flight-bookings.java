class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
       int[] answer = new int[n]; 
        
        for(int[] innerArr : bookings)
        {
            int numberOfSeats = innerArr[2]; 
            
            for(int i = innerArr[0]; i <= innerArr[1]; i++)
            {
                answer[i-1] += numberOfSeats;  
            }
        }
        
        return answer; 
    }
}
