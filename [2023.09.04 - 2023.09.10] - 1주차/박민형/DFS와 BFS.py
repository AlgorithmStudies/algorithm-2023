from collections import defaultdict
from collections import deque

N, M, V = map(int, input().split())
connect = [list(map(int, input().split())) for _ in range(M)]
visited = [False] * N
board_dict = defaultdict(list)
for item in connect:
    board_dict[item[0] - 1].append(item[1] - 1)
    board_dict[item[1] - 1].append(item[0] - 1)

def dfs(v):
    visited[v] = True
    print(v + 1, end=' ')

    for i in sorted(board_dict[v]):
        if not visited[i]:
            visited[i] = True
            dfs(i)

def bfs(v):
    print(v + 1, end=' ')
    visited[v] = True
    queue = deque(sorted(board_dict[v]))

    while queue:
        nv = queue.popleft()
        if not visited[nv]:
            print(nv + 1, end=' ')
            queue += sorted(board_dict[nv])
            visited[nv] = True

dfs(V - 1)
visited = [False] * N
print()
bfs(V - 1)