# 1. bridge 변수 사용
# 2. bridge_length 만큼 bridge에 트럭이 있다면 bridge shift
# 3. 새로운 트럭을 넣어줄 때 다리 위의 트럭의 무게 총합과 현재 트럭의 무게를 더했을 때
# => 더한 값이 다리가 버틸 수 있는 무게를 초과한다면 pass
# => 초과하지 않는다면 트럭 넣어주기

from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([])
    truck_weights_queue = deque(truck_weights)
    bridge_weight = 0
    answer = 0

    while len(truck_weights_queue) > 0:
        answer += 1
        if len(bridge) == bridge_length:
            shift_weight = bridge.popleft()
            bridge_weight -= shift_weight

        if bridge_weight + truck_weights_queue[0] > weight:
            bridge.append(0)
            continue

        truck_weight = truck_weights_queue.popleft()
        bridge.append(truck_weight)
        bridge_weight += truck_weight

    return answer + bridge_length