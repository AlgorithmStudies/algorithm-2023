# 1. 이전 개수의 최대 가격을 기준으로 현재 개수의 최대 가격 측정
# 2. 반복문 사용 가능(10,000,000)
n = int(input())
card_lst = [0] + list(map(int, input().split()))

dp = [0, card_lst[1]]
for idx in range(2, n + 1):
    max_value = card_lst[idx]
    for j in range(1, idx):
        # 시간 복잡도 줄이기 위해 작성
        if j > idx - j: break
        if dp[j] + dp[idx - j] > max_value:
            max_value = dp[j] + dp[idx - j]

    dp.append(max_value)
print(dp[-1])