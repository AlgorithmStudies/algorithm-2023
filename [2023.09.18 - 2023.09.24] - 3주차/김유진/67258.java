import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        
        //gems에서 중복 없는 모든 보석의 갯수
        Set<String> nonDuplicatedGems=new HashSet<>(Arrays.asList(gems));
        int cnt=nonDuplicatedGems.size();
        
        int ans=Integer.MAX_VALUE; int[] ansRange=null;
        int left=0, right=0;
        
        //HashMap 생성
        HashMap<String, Integer> cart=new HashMap();
        
        while(right<gems.length){
            
            String nowGem=gems[right];
            
            if(cart.containsKey(nowGem)){
                cart.put(nowGem, cart.get(nowGem)+1);
            } else{
                cart.put(nowGem, 1);
            }
            
            //만족하는지 
            while(cart.size()==cnt){
                
                if(ans>right-left+1){
                    ans=right-left+1;
                    
                    int[] newAnsRange={left+1, right+1};
                    ansRange=newAnsRange;
                }
                
                //카트에서 현재 left 값을 지워줌 
                cart.put(gems[left], cart.get(gems[left])-1);
                
                if(cart.get(gems[left])==0)
                    cart.remove(gems[left]);
                
                left++;
            } 
                
            right++;
        }
        
        return ansRange;
    }
}
