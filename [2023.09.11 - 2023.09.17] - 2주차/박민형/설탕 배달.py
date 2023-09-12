# 1. 이전 값을 사용해 현재 값 결정
n = int(input())

dp = [-1, -1, -1, 1, -1, 1]
for idx in range(6, n + 1):
    min_value = -1
    if dp[idx - 3] != -1: min_value = dp[idx - 3] + 1
    if dp[idx - 5] != -1: min_value = dp[idx - 5] + 1
    dp.append(min_value)

print(dp[n])