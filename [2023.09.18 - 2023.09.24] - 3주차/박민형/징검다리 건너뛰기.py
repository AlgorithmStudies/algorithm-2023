# 1. 이분 탐색 이용(건널 수 있는 친구 수를 이용해 풀이)
# 2. mid(특정 시점의 건널 수 있는 친구 수)값에 따라 다른 경우 발생
# => 건널 수 없는 경우, 즉 원소 0이 반복되는 빈도가 k보다 크거나 같을 때(cnt로 check)
# => stone의 특정 원소를 mid로 뺐을 때 만약 0보다 작으면 건널 수 없는 경우(cnt += 1)
# => 0보다 크면 건널 수 있는 경우(cnt = 0)
# 3. 건널 수 없는 경우 right = mid - 1, 건널 수 있는 경우 : left = mid + 1

def solution(stones, k):
    left = 0
    right = 200000000

    while left <= right:
        mid = (left + right) // 2
        cnt = 0

        for stone in stones:
            # mid명 지나갔을 때 해당 stone 더 이상 못 밟는다면
            # mid명은 밟을 수 있지만 mid + 1명은 못 밟으므로 check
            if stone - mid <= 0:
                cnt += 1
            else:
                cnt = 0

            if cnt >= k: break

        if cnt >= k:
            right = mid - 1
        else:
            left = mid + 1

    return left