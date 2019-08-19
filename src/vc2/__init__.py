# 找出落单的数
if __name__ == '__main__':

    data = []

    for i in range(1, 1001):
        data.append(i)

    for i in range(1, 1001):
        data.append(i)

    data.append(51)

    x = 0
    for i in range(0, 2001):
        x = x ^ data[i]

    pass
