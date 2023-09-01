n = int(input())
if n % 5 == 0:
    print(n // 5)
else:
    cnt = 0
    while True:
        cnt += 1
        next_value1 = n - 3
        if next_value1 < 0:
            cnt = -1
            break

        if next_value1 % 5 == 0:
            cnt += (n // 5)
            break
        n -= 3

        if n == 0: break

    print(cnt)