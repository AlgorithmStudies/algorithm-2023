import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 다리놓기 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //mCn 조합
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            double answer = 0;
            double num1 = 1;
            for (int j = M; j > M - N; j--) {
                num1 *= j;
            }

            double num2 = 1;
            for (int k = N; k > 0; k--) {
                num2 *= k;
            }
            answer = num1 / num2;
            System.out.print(answer);
        }
    }
}