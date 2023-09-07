import sys
from collections import deque
input = sys.stdin.readline

def BFS():
    global result_max
    queue = deque()
    queue.append((0, 0, 1))
    visited = [[False] * M for _ in range(N)]

    while queue:
        pop_position_x, pop_position_y, pop_distance = queue.popleft()
        if pop_position_x == N - 1 and pop_position_y == M - 1:
            result_max = pop_distance
            break

        for idx in range(4):
            nx = pop_position_x + vector[idx][0]
            ny = pop_position_y + vector[idx][1]
            if 0 <= nx < N and 0 <= ny < M and maze_map[nx][ny] == '1' and not visited[nx][ny]:
                queue.append((nx, ny, pop_distance + 1))
                visited[nx][ny] = True


N, M = map(int, input().split())
maze_map = [list(input().strip()) for _ in range(N)]
vector = [[-1, 0], [0, 1], [1, 0], [0, -1]]

result_max = 0
BFS()
print(result_max)