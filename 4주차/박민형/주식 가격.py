# 1. stack에 [가격, 가격이 떨어지지 않는 기간, 위치] append
# 2. append 하기전에 stack의 마지막 price가 현재 price보다 크다면 계속 pop 및 result 값 최신화
# 3. stack에 남은 애들 result 값 최신화

def solution(data):
    result = [0] * len(data)

    stack = [[data[0], len(data) - 1, 0]]
    for idx, price in enumerate(data[1:], 1):
        while stack and stack[-1][0] > price:
            result[stack[-1][2]] = idx - stack[-1][2]
            stack.pop()
        stack.append([price, len(data) - (idx + 1), idx])

    for value in stack:
        result[value[2]] = value[1]

    return result

