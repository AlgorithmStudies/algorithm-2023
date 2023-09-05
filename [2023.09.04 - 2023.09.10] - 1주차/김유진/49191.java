import java.util.*;

class Node implements Comparable<Node>{
    int x; int y; int num;
    Node prev=null; Node next=null; 
    
    public Node(int x, int y, int num){
        this.x=x;
        this.y=y;
        this.num=num;
    }
    
    public int compareTo(Node n){
        return n.y-this.y;
    }
}

class Solution {
    
    static Node[] nodes;
    static Node root;
    static List<Integer> preOrderList=new ArrayList();
    static List<Integer> postOrderList=new ArrayList();
        
    public static int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> queue=new PriorityQueue();
        nodes=new Node[nodeinfo.length+1];
        
        for(int i=0;i<nodeinfo.length;i++){
            int[] coordinate=nodeinfo[i];
            Node node=new Node(coordinate[0], coordinate[1], i+1);
            nodes[i]=node;
            
            queue.add(node);
        }
        
        root=queue.poll();
        while(!queue.isEmpty()){
            Node n=queue.poll();
            addNode(n);
        }
        
        //전위순회
        preOrder(root);
        
        //후위순회
        postOrder(root);
        
        //ans 정제
        int nodeSize=nodeinfo.length;
        int[] preOrderAns=new int[nodeSize];
        int[] postOrderAns=new int[nodeSize];
    
        for(int i=0;i<nodeSize;i++){
            preOrderAns[i]=preOrderList.get(i);
            postOrderAns[i]=postOrderList.get(i);
        }
        
        int[][] ans={
            preOrderAns, postOrderAns
        };
        
        return ans;
    }
    
    //전위
    static void preOrder(Node n){
        if(n==null)
            return;
        
        preOrderList.add(n.num);
        preOrder(n.prev);
        preOrder(n.next);
    }
    //후위
    static void postOrder(Node n){
        if(n==null)
            return;
        
        postOrder(n.prev);
        postOrder(n.next);
        postOrderList.add(n.num);
    }
    
    //tree에 값 넣기 
    static void addNode(Node n){
        Node current=root;
        
        while(true){
            if(current.x>n.x){
                if(current.prev==null){
                    current.prev=n;
                    break;
                }
                current=current.prev;
            } else{
                if(current.next==null){
                    current.next=n;
                    break;
                }
                current=current.next;
            }
        }
    }
}
