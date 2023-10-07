import java.util.*;

class Solution {
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb=new StringBuilder();
        
        int left='*'; int right='#';
        Map<Integer, Integer> map=new HashMap(); //l-0 r-1
        map.put(1, 0); map.put(4, 0); map.put(7, 0); map.put(left, 0);
        map.put(3, 1); map.put(6, 1); map.put(9, 1); map.put(right, 1);
        
        for(int number:numbers){
            if(map.containsKey(number)){
                int nextHand=map.get(number);
                
                if(nextHand==0){
                    left=number;
                    sb.append("L");
                }else{
                    right=number;
                    sb.append("R");
                }
                
                continue;
            }
            
            //중간 번호
            int leftDist=getDist(map, left, number);
            int rightDist=getDist(map, right, number);
            
            if(leftDist==rightDist){
                if(hand.equals("left")){
                    left=number;
                    sb.append("L");
                }else{
                    right=number;
                    sb.append("R");
                }
                
                continue;
            }
            
            if(leftDist<rightDist){
                left=number;
                sb.append("L");
            } else{
                right=number;
                sb.append("R");
            }
        }
        
        return sb.toString();
    }
    
    private int getDist(Map<Integer, Integer> map, int handPos, int target){
        int cnt=0;
        
        int targetLine=getLine(target);
        int handLine=getLine(handPos);
        int moveLine=targetLine-handLine;
        
        cnt+=(moveLine<0?moveLine*-1:moveLine);
        
        //현재 handPos의 위치에 따라 좌우 움직임 필요
        if(!map.containsKey(handPos))
            return cnt;
        
        return cnt+1;
    }
    
    private int getLine(int target){
        if (target=='*' || target==0 || target=='#')
            return 4;
        
        int line=1;
        
        while(target>line*3){            
            line++;
        }
        
        return line;
    }
}
