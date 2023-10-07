import java.util.*;

class Cost implements Comparable<Cost>{
    int i1; 
    int i2;
    int cost;
    
    public Cost(int i1, int i2, int cost){
        this.i1=i1; 
        this.i2=i2;
        this.cost=cost;
    }
    
    public int compareTo(Cost c){
        return this.cost-c.cost;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        
        PriorityQueue<Cost> queue=new PriorityQueue();
        for(int[] cost: costs){
            queue.add(new Cost(cost[0], cost[1], cost[2]));
        }
        
        //Parent Array
        int[] parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        
        int sum=0;
        while(!queue.isEmpty()){
            Cost nowCost=queue.poll();
            
            if(isPossible(nowCost, parents)){
                combine(nowCost, parents);
                sum+=nowCost.cost;
            }
        }
        
        return sum;
    }
    
    private void combine(Cost cost, int[] parents){
        int i1=cost.i1; int i2=cost.i2;
        int p1=getParent(i1, parents); int p2=getParent(i2, parents);
        
        parents[p2]=p1;
    }
    
    private boolean isPossible(Cost cost, int[] parents){
        int i1=cost.i1; int i2=cost.i2;
        int p1=getParent(i1, parents); int p2=getParent(i2, parents);
        
        if(p1==p2)
            return false;
        
        return true;
    }
    
    private int getParent(int island, int[] parents){
        
        if(island==parents[island])
            return island;
        
        return getParent(parents[island], parents);
    }
}
