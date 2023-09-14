# 1. stack에 [price, index] append
# 2. stack의 top price보다 현재 price가 작다면 stack에서 price pop 후 결과 리스트에 기간 값 저장

def solution(data):
    result = [0] * len(data)
    stack = [[data[0], 0]]

    for idx, item in enumerate(data[1:], 1):
        while stack and item < stack[-1][0]:
            pop_idx = stack.pop()[1]
            result[pop_idx] = idx - pop_idx

        stack.append([item, idx])

    for item in stack:
        result[item[1]] = len(data) - 1 - item[1]

    return result