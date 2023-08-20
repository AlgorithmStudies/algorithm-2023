# 1. 각 아이템 별 누적 값 저장
# 2. 마지막 아이템까지의 영역에서 포함되지 않는 영역을 제거함으로써 결과값 구하기
import sys
input = sys.stdin.readline

n, cnt = map(int, input().split())
board = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]
area = [list(map(int, input().split())) for _ in range(cnt)]

board_dp = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        board_dp[i][j] = board_dp[i][j - 1] + board_dp[i - 1][j] - board_dp[i - 1][j - 1] + board[i][j]

for x1, y1, x2, y2 in area:
    result = board_dp[x2][y2] - board_dp[x2][y1 - 1] - board_dp[x1 - 1][y2] + board_dp[x1 - 1][y1 - 1]
    print(result)