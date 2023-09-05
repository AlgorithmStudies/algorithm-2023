import java.util.*;

class Solution {
    
    static LinkedList<Integer>[] wins; //각 player이 이긴 player
    static LinkedList<Integer>[] loses; //각 player이 진 player
    static int nSize;
    
    public static int solution(int n, int[][] results) {
        //wins, loses initialize
        nSize=n;
        wins=new LinkedList[nSize+1];
        loses=new LinkedList[nSize+1];
        
        
        for(int i=0;i<=nSize;i++){
            wins[i]=new LinkedList();
            loses[i]=new LinkedList();
        }
        
        for(int[] result:results){
            int winner=result[0]; int loser=result[1];
            
            wins[winner].addLast(loser);
            loses[loser].addLast(winner);
        }
        
        int cnt=0;
        for(int i=1;i<=nSize;i++){
            if(canRank(i))
                cnt++;
        }
        
        return cnt;
    }
    
    //현재 i번 선수가 순위를 매길 수 있는지 
    static boolean canRank(int i){
        int cnt=0;
        LinkedList<Integer> iWin=wins[i];
        LinkedList<Integer> iLose=loses[i];
        
        boolean[] visited=new boolean[nSize+1];
        LinkedList<Integer> queue=new LinkedList();
        visited[i]=true;
        queue.addLast(i);
    
        //1. 현재 i가 이긴 선수들 집계 -> 이긴 선수들이 이긴 선수들 집계 -> ... 
        // = i보다 낮은 랭크 집계 
        while(!queue.isEmpty()){
            int player=queue.poll();
            LinkedList<Integer> playerWins=wins[player];
            
            for(int pw:playerWins){
                if(!visited[pw]){
                    visited[pw]=true;
                    queue.addLast(pw);
                    cnt++;
                }
            }
        }
        
        //2. i가 진 선수들 집계 -> 진 선수들이 진 선수들 집계 -> ...
        // = i보다 높은 랭크 집계 
        queue.addLast(i);
        while(!queue.isEmpty()){
            int player=queue.poll();
            
            LinkedList<Integer> playerLoses=loses[player];
            for(int pl:playerLoses){
                if(!visited[pl]){
                    cnt++;
                    visited[pl]=true;
                    queue.addLast(pl);
                }
            }
        }
        
        return cnt==nSize-1?true:false;
    }
}
