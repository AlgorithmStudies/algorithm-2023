import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nums=br.readLine().split(" ");
        int n=Integer.parseInt(nums[0]); int k=Integer.parseInt(nums[1]);
        
        int[] inputs=new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            inputs[i]=Integer.parseInt(st.nextToken());
        }
        
        //갯수 기록 위한 배열 
        int[] cnt=new int[100000+1];
        int ans=Integer.MIN_VALUE;
        
        int left=0, right=0;
        while(right<n){
            if (cnt[inputs[right]]==k){
                cnt[inputs[left]]-=1;
                left++;
            } else{
                
                if(ans<right-left+1)
                    ans=right-left+1;
                
                cnt[inputs[right]]+=1;
                right++;
            }
        }
        
        System.out.print(ans);
    }
}
