import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] ns=new int[n+1];
        for(int i=1;i<=n;i++){
            ns[i]=Integer.parseInt(br.readLine());
        }

        int[] d=new int[n+1];

        d[1]=ns[1]; 

        //크기 봐서 해줌
        if(n>=2) 
            d[2]=d[1]+ns[2];

        for(int i=3;i<=n;i++){
            //1. 이전 단계를 밟는 경우 d[i-3]+ns[i-1]+ns[i]
            //2. 이전 단계를 밟지 않는 경우 d[i-2]+ns[i]
            d[i]=Math.max(d[i-3]+ns[i-1]+ns[i], d[i-2]+ns[i]);
        }

        System.out.print(d[n]);
    }
}
