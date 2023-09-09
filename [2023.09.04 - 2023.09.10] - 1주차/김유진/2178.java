import java.util.*;
import java.io.*;

class Main{

    static int[][] displacements={
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums=br.readLine().split(" ");
        int n=Integer.parseInt(nums[0]); int m=Integer.parseInt(nums[1]);

        int[][] arr=new int[n][m];

        for(int i=0;i<n;i++){
            char[] row=br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                arr[i][j]=row[j]-'0';
            }
        }

        //o, o~n-1, m-1
        LinkedList<int[]> queue=new LinkedList();

        int[] start={0, 0};
        queue.addLast(start);

        while(!queue.isEmpty()){
            int[] now=queue.poll();

            for(int[] dp:displacements){
                int newI=now[0]+dp[0];
                int newJ=now[1]+dp[1];

                if(newI<0 || newI>=n || newJ<0 || newJ>=m)
                    continue;

                if(arr[newI][newJ]==1){
                    int[] coordinate={newI, newJ};
                    queue.addLast(coordinate);

                    arr[newI][newJ]=arr[now[0]][now[1]]+1;
                }
            }
        }

        System.out.print(arr[n-1][m-1]);
    }
}
