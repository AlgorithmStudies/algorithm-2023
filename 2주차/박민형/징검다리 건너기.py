# 1. 각 돌에 도착했을 때 최소 에너지를 메모이제이션
# 2. 세가지 경우의 수 고려(작은 점프, 큰 점프, 매우 큰 점프)
# 3. 고려해야 할 사항
# => 매우 큰 점프시 이전 돌이 작은 점프 및 큰 점프로만 진행한 경우에만 가능(매우 큰 점프를 한 경우도 있을 수 있음)
# => 작은 점프 및 큰 점프를 할 때 매우 큰 점프로 진행했던 경우 선택이 최소값 일 수도 있음

# 참조 코드
import sys
input = sys.stdin.readline

N = int(input())
stone = []

# dp 배열 생성
dp = [1e9]*N
dp[0] = 0
for i in range(N-1):
    s, b = map(int, input().split())
    stone.append((s, b))
    if i+1<N: dp[i+1] = min(dp[i+1], dp[i]+s)
    if i+2<N: dp[i+2] = min(dp[i+2], dp[i]+b)

# 매우 큰 점프 적용해보며 최솟값 찾기
K = int(input())

_min = dp[-1]
for i in range(3, N):
    e, one_jump, two_jump = dp[i-3]+K, 1e9, 1e9
    for j in range(i, N-1):
        if i+1 < N: one_jump = min(one_jump, e+stone[j][0])
        if i+2 < N: two_jump = min(two_jump, e+stone[j][1])
        # print(one_jump, two_jump)
        e, one_jump, two_jump = one_jump, two_jump, 1e9
    _min = min(_min, e)

print(_min)import sys
input = sys.stdin.readline

N = int(input())
stone = []

# dp 배열 생성
dp = [1e9]*N
dp[0] = 0
for i in range(N-1):
    s, b = map(int, input().split())
    stone.append((s, b))
    if i+1<N: dp[i+1] = min(dp[i+1], dp[i]+s)
    if i+2<N: dp[i+2] = min(dp[i+2], dp[i]+b)

# 매우 큰 점프 적용해보며 최솟값 찾기
K = int(input())

_min = dp[-1]
for i in range(3, N):
    e, one_jump, two_jump = dp[i-3]+K, 1e9, 1e9
    for j in range(i, N-1):
        if i+1 < N: one_jump = min(one_jump, e+stone[j][0])
        if i+2 < N: two_jump = min(two_jump, e+stone[j][1])
        # print(one_jump, two_jump)
        e, one_jump, two_jump = one_jump, two_jump, 1e9
    _min = min(_min, e)

print(_min)import sys
input = sys.stdin.readline

N = int(input())
stone = []

# dp 배열 생성
dp = [1e9]*N
dp[0] = 0
for i in range(N-1):
    s, b = map(int, input().split())
    stone.append((s, b))
    if i+1<N: dp[i+1] = min(dp[i+1], dp[i]+s)
    if i+2<N: dp[i+2] = min(dp[i+2], dp[i]+b)

# 매우 큰 점프 적용해보며 최솟값 찾기
K = int(input())

_min = dp[-1]
for i in range(3, N):
    e, one_jump, two_jump = dp[i-3]+K, 1e9, 1e9
    for j in range(i, N-1):
        if i+1 < N: one_jump = min(one_jump, e+stone[j][0])
        if i+2 < N: two_jump = min(two_jump, e+stone[j][1])
        # print(one_jump, two_jump)
        e, one_jump, two_jump = one_jump, two_jump, 1e9
    _min = min(_min, e)

print(_min)

# 틀린 코드
# n = int(input())
# stone_lst = [[0, 0]] + [list(map(int, input().split())) for _ in range(n - 1)]
# max_energy = int(input())
#
# dp = [[0, 0, 0], [stone_lst[1][0], 0, 0]]
#
# for idx in range(2, n):
#     value1 = min(stone_lst[idx][0] + dp[idx - 1][0], stone_lst[idx][1] + dp[idx - 2][0])
#     value2 = min(stone_lst[idx][0] + dp[idx - 1][2], stone_lst[idx][1] + dp[idx - 2][2]) if idx >= 4 else 0
#     value3 = dp[idx - 3][0] + max_energy if idx >= 3 else 0
#     dp.append([value1, value2, value3])
#
# print(min(dp[-1]))