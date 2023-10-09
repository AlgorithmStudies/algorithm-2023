//완전탐색 해도 1초 안 

class Solution {
    public int solution(int[] numbers, int target) {
        return backTracking(numbers, 0, 0, target);
    }
    
    private int backTracking(int[] numbers, int idx, int sum, int target){
        if(idx==numbers.length){
            if(sum==target)
                return 1;
            
            return 0;
        }
        
        int cnt=0;
        
        cnt+=backTracking(numbers, idx+1, sum+numbers[idx], target);
        cnt+=backTracking(numbers, idx+1, sum-numbers[idx], target);
        
        return cnt;
    }
}
