import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기_1010 {
    // 다리 건설 경우의 수
	    private static final int[][] dp = new int[31][31];

        public static void main(String[] args) throws IOException {
    	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    	        // 케이스 수
    	        int T = Integer.parseInt(reader.readLine());

    	        for (int i = 0; i < T; i++) {
            	    String[] temp = reader.readLine().split(" ");

            	    int N = Integer.parseInt(temp[0]);
            	    int M = Integer.parseInt(temp[1]);

            	    System.out.println(combination(M, N));
                }
                reader.close();
        }

        	    private static int combination(int n, int r) {
        	        // 이미 계산된 값일 경우
        	        if (dp[n][r] > 0) {
                        return dp[n][r];
                    }
        	        // 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
        	        else if (n == r || r == 0) {
                        return dp[n][r] = 1;
                    }
        	        // 일반적인 경우
        	        else {
        	            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        	        }
          }
}
