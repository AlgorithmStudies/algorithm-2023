import java.util.Scanner;

public class 계단오르기 {
    public static void main(String[] args) {
        //n-3을 밟고 n-1번 계단을 밟고 오는 경우와 n-2번을 밟고 오는 경우 2가지
        //2가지 중 큰 값 + 현재 계단의 값을 더한 값
        //score[n] = Math.max(score[n-3] + stair[n-1], score[n-2]) + stair[n]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stair = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= N; i++)
            stair[i] = sc.nextInt();

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n <= N; n++) {
            dp[n] = Math.max(dp[n - 3] + stair[n - 1], dp[n - 2]) + stair[n];
        }

        System.out.println(dp[N]);
    }
}
