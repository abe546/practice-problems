
class Solution(object):   
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        hashMap = {}
        
        for item in nums:
            if item in hashMap:
                hashMap[item] +=1
            else:
                hashMap[item] = 1
                
        heap = []
        
        for key in hashMap:
            heapq.heappush(heap, (-hashMap[key], key))
            
        result = []
        
        for _ in range(k):
            pop = heapq.heappop(heap)
            result.append(pop[1])
        
        return result;
        