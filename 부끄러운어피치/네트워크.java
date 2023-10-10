import java.util.*;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 방문 여부를 저장하는 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 컴퓨터인 경우
                bfs(i, n, computers, visited); // BFS 탐색을 시작하여 연결된 그룹을 찾음
                answer++; // 연결된 그룹 개수 증가
            }
        }

        return answer;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 큐에 시작 노드 추가
        visited[start] = true; // 시작 노드를 방문했다고 표시

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드를 꺼냄

            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    // 현재 노드와 연결되어 있고 아직 방문하지 않은 노드인 경우
                    queue.offer(i); // 큐에 추가
                    visited[i] = true; // 방문했다고 표시
                }
            }
        }
    }
}