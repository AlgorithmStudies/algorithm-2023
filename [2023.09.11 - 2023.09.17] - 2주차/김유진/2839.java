import java.util.*;

//설탕 3, 5

class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        
        int cnt=0;
        while(n>0){
            if(n%5==0){
                cnt+=n/5;
                n=0;
            } else{
                n-=3;
                cnt++;
            }
        }
        
        cnt=n<0?-1:cnt;
        System.out.print(cnt);
    }
}
