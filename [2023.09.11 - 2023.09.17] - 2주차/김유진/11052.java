import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] p;
    static int[] d;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        p=new int[n+1];
        d=new int[n+1];

        String[] nums=br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            p[i]=Integer.parseInt(nums[i-1]);
        }
        dp(n);

        System.out.print(d[n]);
    }

    static int dp(int num){
        if(num==0)
            return 0;

        if(d[num]!=0)
            return d[num];

        //최댓값
        int max=-1;
        for(int i=1;i<=num;i++){
            //i에 해당하는 카드팩 구입
            int cost=p[i];
            int rest=num-i;

            if(d[rest]==0)
                d[rest]=dp(rest);

            cost+=d[rest];

            if(max<cost)
                max=cost;
        }

        return d[num]=max;
    }
}
