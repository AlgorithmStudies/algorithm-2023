# 1. 크루스칼 알고리즘 사용(최소 비용으로 그래프를 연결할 때 사용)

def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: x[2])
    link = set([costs[0][0]])

    while len(link) < n:
        for cost in costs:
            # 이미 최소비용으로 두 섬간 연결이 되어있는 경우
            if cost[0] in link and cost[1] in link:
                continue
            # 한 섬만 연결되어 있는 경우
            if cost[0] in link or cost[1] in link:
                link.update([cost[0], cost[1]])
                answer += cost[2]
                break

    return answer