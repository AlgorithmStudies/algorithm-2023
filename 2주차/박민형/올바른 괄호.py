def solution(s):
    stack = []
    for item in s:
        if item == '(':
            stack.append('(')
        else:
            if not stack:
                return False
            else:
                stack.pop()

    return True if not stack else False