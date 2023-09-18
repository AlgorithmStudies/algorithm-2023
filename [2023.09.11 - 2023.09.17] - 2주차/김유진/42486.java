import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] remains=new int[n];
        
        LinkedList<Integer> queue=new LinkedList();
        List<Integer> ans=new ArrayList();
        
        for(int i=0;i<n;i++){
            int date=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0)
                date+=1;
            
            if(queue.isEmpty()){
                queue.addLast(date);
                continue;
            } 
            
            if(queue.peek()<date){
                ans.add(queue.size());
                queue.clear();
            }
            
            queue.addLast(date);
        }
        
        ans.add(queue.size());
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}
