import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2178 {
    static int[][] miroMap;
    static int[][] visited;
    static int[] directX = {-1,1,0,0};
    static int[] directY = {0,0,-1,1};
    static int n,m;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miroMap = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                miroMap[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(visited[n-1][m-1]);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.add(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //동서남북 방향으로 나아가며
            for (int i = 0; i < 4; i++) {
                int nx = node.x + directX[i];
                int ny = node.y + directY[i];
                //미로의 끝인지 판단
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    //방문노드인지 여부와 맵의 미로가 탐색가능한지 판단.
                    if (visited[nx][ny] == 0 && miroMap[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = visited[node.x][node.y] + 1;//큐에 +1 거리만큼 더한다.
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
