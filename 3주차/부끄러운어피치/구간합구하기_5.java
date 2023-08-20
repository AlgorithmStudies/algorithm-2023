import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());//5행 5열의 행렬
        int m = Integer.parseInt(st.nextToken());//합을 구해야하는 횟수
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];//dp배열
        for (int i = 1; i <= n; i++) {//행렬을 초기화한다.
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dp배열 초기화, 누적합 배열을 구한다. 2차원 배열의 누적 합 계산 방법
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
                //dp 배열의 공식 = 바로 전 행 열의 값을 누적 - 중복 값 빼기 + 앞으로 누적할값
            }
        }

        //1 1      =  0 1   + 1 0   + 0 0 +   1 1
        //1 2      =  1 2   + 1 1   + 0 1   +  1 2   -- 0 +
        //3 3      =  2 3   + 3 2   + 2 2  + 3 3

        //2차원 배열의 구간 합 계산 방법  각 구간 합 빼고 중복으로 뺀값을 더한다.
        for (int k = 1; k <= m; k++) {//합을 구해야하는 횟수
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}