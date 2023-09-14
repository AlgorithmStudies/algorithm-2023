import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[] d=new int[n+1];

        dp(n, d);
        if(d[n]%2==1){
            System.out.print("SK");
        }else{
            System.out.print("CY");
        }
    }

    static private int dp(int num, int[] d){
        if (num==0)
            return 0;
        if (d[num]!=0)
            return d[num];

        if (num>=3){
            d[num]=dp(num-3, d)+1;
        } else{
            d[num]=dp(num-1, d)+1;
        }

        return d[num];
    }
}
