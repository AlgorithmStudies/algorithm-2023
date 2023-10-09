import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//슬라이딩 윈도우 기법
public class backjun_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int K = Integer.parseInt(st.nextToken()); // 최대 중복 허용 횟수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0; // 최대 길이 저장
        int left = 0; // 윈도우의 왼쪽 인덱스
        int right = 0; // 윈도우의 오른쪽 인덱스
        Map<Integer, Integer> countMap = new HashMap<>(); // 숫자의 개수를 저장하는 맵

        while (right < N) {
            int num = arr[right];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // 중복 숫자가 K번 초과하는 경우, left 포인터를 이동시킴
            while (countMap.get(num) > K) {
                int leftNum = arr[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                left++;
            }

            // 현재 길이를 최대 길이와 비교하여 갱신
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        System.out.println(maxLen);
    }
}
