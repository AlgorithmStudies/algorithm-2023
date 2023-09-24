import java.util.Arrays;
import java.util.Comparator;

class 섬연결하기 {
    private int[] findParent;	//부모배열
    public int solution(int n, int[][] costs) {
/*
        가중치를 기준으로 배열을 정렬
        그렇게 정렬된 배열을 이용을 해서 가중치가 가장 작은 것 부터 연결
        그렇게 연결이 되게 되면, Parent 값을 두 수 중 작은 값으로 지정
        보통 왼쪽의 값이 작으므로 왼쪽의 값을 부모노드로 사용
        모든 costs를 확인해서 결과값을 찾기
*/
        //가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });

        //부모노드 초기화 , 시작은 자기자신이 부모
        findParent = new int[n];
        for (int i = 0; i < findParent.length; i++) {
            findParent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {	//출발지를 start, 도착지를 end
            int start = find(costs[i][0]);
            int end = find(costs[i][1]);
            if (start != end) { // 부모가 같지 않다면 연결이 안된 최솟값이므로
                findParent[end] = start; // 연결
                answer += costs[i][2];
            }
        }
        return answer;

    }
    //부모노드 값을 찾는 메서드
    private int find(int child) {
        if (findParent[child] == child) {
            return child;
        } else {
            return findParent[child] = find(findParent[child]);
        }
    }
}