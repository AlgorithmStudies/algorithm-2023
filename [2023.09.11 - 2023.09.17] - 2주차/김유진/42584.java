import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int price;
    
    public Node(int idx, int price){
        this.idx=idx;
        this.price=price;
    }
    
    public int compareTo(Node n){
        return n.price-this.price;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int n=prices.length;
        PriorityQueue<Node> queue=new PriorityQueue();
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++){
            int price=prices[i];
            
            while(!queue.isEmpty()){
                Node highestNode=queue.peek();
                
                if(highestNode.price<=price)
                    break;
                
                //가격 떨어졌을 때
                highestNode=queue.poll(); //1. 빼주고
                //2. ans에 기간 정의
                ans[highestNode.idx]=i-highestNode.idx;
            }
            
            Node newNode=new Node(i, prices[i]);
            queue.add(newNode);
        }
        
        //queue에 남아있는 것들 ans 정의
        while(!queue.isEmpty()){
            Node node=queue.poll();
            ans[node.idx]=n-1-node.idx;
        }
        
        return ans;
    }
}
