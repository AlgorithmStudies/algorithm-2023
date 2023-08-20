import java.io.*;
import java.util.*;

public class 징검다리건너기 {
    static int n, k;
    static int[][] arr;
    static int answer = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());//돌의 개수

        arr = new int[n][n];//각 돌의 작은 점프와 큰점프를 저장할 배열
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());//매우 큰 점프
        go(0, 1, false);
        System.out.println(answer);
    }

    static void go(int sum, int to, boolean useMax) {
        // n 번째 돌에 오면 최소값 체크 후 종료
        if (to == n) {//지금까지 구한것 중 최소값
            answer = Math.min(answer, sum);
            return;
        }

        // n 번째 돌을 넘어가면 종료
        if (to > n) return;

        go(sum + arr[to][0], to + 1, useMax);   // 1칸  작은 점프일때의 사용량 누적합, 돌의개수 +1,
        go(sum + arr[to][1], to + 2, useMax);   // 2칸

        // 3단점프를 사용하지 않았을 때만 사용한다.
        if (!useMax) {//가장 큰 점프
            go(sum + k, to + 3, true);
        }
    }
}
