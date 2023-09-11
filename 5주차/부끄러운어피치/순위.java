public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        /* 승리 전적표 채우기 */
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] i : results)
            map[i[0]][i[1]] = true;
            //ex (4번선수  3번선수),       (4번선수   2번선수)
             map[ [4,3], [4,2] ] = true

             //전적을 모두 true로 채운다.



        /* 플루이드 와샬 알고리즘을 통해 승리 채우기 */
        for (int k = 1; k <= n; ++k) { // 가운데 선수
            for (int i = 1; i <= n; ++i) { // 강한 선수
                for (int j = 1; j <= n; ++j) { // 약한 선수
                        강 가              가 약
                        강한선수  가운데선수 붙으면   강한선수 승리
                        가운데선수 약한선수 붙으면 가운데선수 승리
                        강 약도 논리에따라 승리
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }

        /* 모든 전적을 알 수 있는 선수의 수 구하기 */
        for (int i = 1; i <= n; ++i) {
            boolean possible = true;
            for (int j = 1; j <= n; ++j) {
                //서로의 전적이 모두 false면 알수없음. 알수없는 표시 false체크 , 서로의 전적이 판단가능한수만 카운팅
                if (i != j && !map[i][j] && !map[j][i]) {
                    possible = false;
                    break;
                }
            }
            answer = possible ? answer + 1 : answer;
        }
        //정확하게 순위를 매길 수 있는 선수의 수 true인것만
        return answer;
    }
}
