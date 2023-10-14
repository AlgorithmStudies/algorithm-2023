import java.util.*;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 체육복을 잃어버린 학생 수만큼 미리 빼놓습니다.

        // 여벌 체육복을 가져온 학생이 도난당한 경우를 처리합니다.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++; // 체육복을 빌려받을 수 있는 학생 수 증가
                    break;
                }
            }
        }

        // 여벌 체육복을 가진 학생이 도난당한 학생에게 빌려주는 경우를 처리합니다.
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] != -1) {
                for (int j = 0; j < reserve.length; j++) {
                    if (reserve[j] != -1 && (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1)) {
                        reserve[j] = -1;
                        answer++; // 체육복을 빌려받을 수 있는 학생 수 증가
                        break;
                    }
                }
            }
        }

        return answer;
    }
}