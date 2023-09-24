import java.util.*;
/*
        가중치를 기준으로 배열을 정렬
        그렇게 정렬된 배열을 이용을 해서 가중치가 가장 작은 것 부터 연결
        그렇게 연결이 되게 되면, Parent 값을 두 수 중 작은 값으로 지정
        보통 왼쪽의 값이 작으므로 왼쪽의 값을 부모노드로 사용
        모든 costs를 확인해서 결과값을 찾기
*/
class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2])); // 가중치 기준 정렬

        //부모노드 초기화 , 시작은 자기자신이 부모
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 각 섬을 개별 집합으로 초기화
        }

        int minCost = 0;
        int edgeCount = 0;//섬의 연결여부 판단.

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int costValue = cost[2];
            // 부모가 같지 않다면 연결이 안된 최솟값이므로
            if (find(parent, from) != find(parent, to)) {
                // 두 섬이 같은 집합에 속하지 않으면 연결
                union(parent, from, to);
                minCost += costValue;
                edgeCount++;
            }

            if (edgeCount == n - 1) {
                // 모든 섬이 연결되면 종료
                break;
            }
        }

        return minCost;
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        parent[rootA] = rootB;
    }
}
