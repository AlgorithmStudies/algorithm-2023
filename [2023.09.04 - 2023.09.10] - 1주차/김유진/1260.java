import java.util.*;
import java.io.*;

class Main{

    static int n, v;
    static LinkedList<Integer>[] arr;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums=br.readLine().split(" ");

        n=Integer.parseInt(nums[0]); int m=Integer.parseInt(nums[1]); v=Integer.parseInt(nums[2]);

        arr=new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new LinkedList();
        }

        for(int i=0; i<m; i++){
            nums=br.readLine().split(" ");
            int p1=Integer.parseInt(nums[0]); int p2=Integer.parseInt(nums[1]);

            //입력값 오름차순으로
            int idx1=0; int idx2=0;
            for(;idx1<arr[p1].size();idx1++){
                if(arr[p1].get(idx1)>p2)
                    break;
            }

            for(;idx2<arr[p2].size();idx2++){
                if(arr[p2].get(idx2)>p1)
                    break;
            }

            arr[p1].add(idx1, p2); arr[p2].add(idx2, p1);
        }

        dfs();
        bfs();

        System.out.print(sb);
    }

    private static void dfs(){
        //v에서 시작
        boolean[] visited=new boolean[n+1];
        dfsUtil(v, visited);
        sb.append("\n");
    }

    private static void dfsUtil(int start, boolean[] visited){
        visited[start]=true;
        sb.append(start).append(" ");

        for(int near:arr[start]){
            if(!visited[near])
                dfsUtil(near, visited);
        }
    }

    private static void bfs(){
        LinkedList<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1];

        queue.add(v);
        visited[v]=true;

        while(!queue.isEmpty()){
            int now=queue.poll();
            sb.append(now).append(" ");

            for(int near:arr[now]){
                if(!visited[near]){
                    visited[near]=true;
                    queue.add(near);
                }
            }
        }

        sb.append("\n");
    }
}
