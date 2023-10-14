import java.util.LinkedList;
import java.util.Queue;

class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 시작 지점 좌표와 거리 1을 큐에 추가

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == n - 1 && y == m - 1) {
                return distance; // 도착 지점에 도달하면 거리를 반환
            }

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // 새로운 좌표가 범위 내에 있고, 벽이 아니라면 큐에 추가
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0; // 방문한 지점은 0으로 표시 (재방문 방지)
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1; // 도착 지점에 도달하지 못한 경우 -1 반환
    }
}