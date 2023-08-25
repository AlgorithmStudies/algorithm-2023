n = int(input())
nums = list(map(int, input().split()))
dp = [0] * (n + 1)
dp[1] = nums[0]

for idx in range(2, n + 1):
    for j in range(1, idx + 1):
        dp[idx] = max(dp[idx], dp[idx - j] + nums[j - 1])

print(dp[n])