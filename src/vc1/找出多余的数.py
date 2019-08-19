# 找出多余的数
if __name__ == '__main__':

    data = []
    for i in range(1, 1001):
        data.append(i)
    data.append(51)
    data[50] = 28

    x = 0
    for i in range(1, 1001):
        x = x ^ i

    for i in range(0, 1001):
        x = x ^ data[i]

    pass
