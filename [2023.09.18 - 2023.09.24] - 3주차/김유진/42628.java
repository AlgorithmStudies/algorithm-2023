//감이 안 와서 그리디하게 접근하도록. n^2logn인데 시간초과 가능성 농후함.. n=1,000,000
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
    
        LinkedList<Integer> queue=new LinkedList();
        
        StringTokenizer st;
        for(String op:operations){
            st=new StringTokenizer(op);
            
            String operation=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            
            if(operation.equals("I")){
                insert(queue, num);
            }
            
            if(operation.equals("D")){
                if(queue.size()==0)
                    continue;
                
                if(num==1){
                    queue.remove(queue.size()-1);
                }else{
                    queue.remove(0);
                }
            }
        }
        
        int[] ans=new int[2];
        
        if(queue.size()!=0){
            int max=queue.get(queue.size()-1);
            int min=queue.get(0);
            
            ans[0]=max; ans[1]=min;
        }
        
        return ans;
    }
    
    private void insert(LinkedList<Integer> queue, int num){
        int idx=0;
        
        for(;idx<queue.size();idx++){
            if(queue.get(idx)>num)
                break;
        }
        
        queue.add(idx, num);
    }
    
}
