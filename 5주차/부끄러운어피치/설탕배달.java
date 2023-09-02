import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;

        while(true) {
            if(N%5==0) {
                count += N / 5;
                break;
            }
            else {
                N -= 3;
                count++;
            }

            if(N<0) {
                break;
            }
        }
    }
}