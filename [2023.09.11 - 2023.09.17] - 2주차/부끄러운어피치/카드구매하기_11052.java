import java.util.Scanner;

public class 카드구매하기_11052 {

/*    문제해석

    카드 N개를 구매
    카드팩에 들어있는 카드가 적은 것부터 산다.
    카드 N개를 구매하는데 드는 비용의 최대를 구하기

	1개 살떄의 금액 최대값 dp[1]
	2개 살떄의 금액 최대값 dp[2]
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] inputArr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            inputArr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
		//max함수로 최대값을 갱신한다.  점화식 dp[i-j] + inputArr[j]
                dp[i] = Math.max(dp[i], dp[i - j] + inputArr[j]);
            }
        }

        System.out.println(dp[n]);

        sc.close();
    }
}
