import java.util.Scanner;

public class 카드구매하기_11052 {

/*    문제해석

    카드 N개를 구매
    카드팩에 들어있는 카드가 적은 것부터 산다.
    카드 N개를 구매하는데 드는 비용의 최대를 구하기

    DP를 풀때 일반항 형태로 정의하는 것이 중요

    일단, 케이스 단위로 생각해보자.
    카드 i개를 구매하는 방법은?
    카드 1개가 들어있는 카드팩을 구매하고, 카드 i-1개를 구입한다.
    카드 2개가 들어있는 카드팩을 구매하고, 카드 i-2개를 구입한다.
    카드 3개가 들어있는 카드팩을 구매하고, 카드 i-3개를 구입한다.
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
                dp[i] = Math.max(dp[i], dp[i - j] + inputArr[j]);
            }
        }

        System.out.println(dp[n]);

        sc.close();
    }
}