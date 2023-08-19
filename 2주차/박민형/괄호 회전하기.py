# 1. 회전 시키기
# 2. 회전 시킨 결과가 올바른 괄호 문자인지 판단

def solution(s):
    current_bracket = list(s)
    answer = 0
    bracket_dic = {'[': ']', '{': '}', '(': ')'}

    for _ in range(len(s)):
        stack = []
        for bracket in current_bracket:
            # 첫 문자가 여는 괄호 문자로 시작하는 경우
            if bracket == '[' or bracket == '{' or bracket == '(':
                stack.append(bracket)

            # 여는 괄호 문자가 stack에 있고 그에 상응하는 닫는 문자일 경우
            elif stack and bracket == bracket_dic[stack[-1]]:
                stack.pop()

            # stack에 아무것도 없을 때 닫힌문자로 시작하는 경우
            elif not stack and (bracket == ']' or bracket == '}' or bracket == ')'):
                answer -= 1
                break

        if not stack: answer += 1
        current_bracket = current_bracket[1:] + list(current_bracket[0])

    return answer