import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] nums=br.readLine().split(" ");
            int left=Integer.parseInt(nums[0]); int right=Integer.parseInt(nums[1]);

            long[][] d=new long[left+1][right+1];

            dp(left, right, d);

            System.out.println(d[left][right]);
        }

    }

    private static long dp(int left, int right, long[][] d){
        if(left==0)
            return 1;

        long sum=0;
        for(int i=right;i>0;i--){
            if(left>i)
                break;

            if(d[left][i]==0)
                d[left][i]=dp(left-1, i-1, d);

            sum+=d[left][i];
        }

        return d[left][right]=sum;
    }
}
