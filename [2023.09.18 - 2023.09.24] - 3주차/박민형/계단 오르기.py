N = int(input())
number_lst = [0] + [int(input()) for _ in range(N)]
dp = [[0, 0], [number_lst[1], number_lst[1]]]

for idx in range(2, N + 1):
    dp.append([number_lst[idx] + dp[idx - 1][1], number_lst[idx] + max(dp[idx - 2])])

print(max(dp[-1]))