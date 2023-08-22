# 1. 각 기능 완료 일수 list 구하기
# 2. list를 순회
# => stack 처음값보다 작으면 count + 1, 크면 새로운 값을 stack에 넣기

import math

def solution(progresses, speeds):
    function_lst = []
    for idx in range(len(progresses)):
        function_lst.append(math.ceil((100 - progresses[idx]) / speeds[idx]))

    result = []
    count = 1
    stack = [function_lst[0]]
    for func_num in function_lst[1:]:
        if stack[-1] >= func_num:
            count += 1
        else:
            result.append(count)
            stack = [func_num]
            count = 1

    result.append(count)
    return result
