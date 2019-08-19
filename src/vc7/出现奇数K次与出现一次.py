# 出现奇数K次与出现一次 不能配次
def getK(data, k):
    s = ''
    for i in range(0, 32):
        s = s + str(int(data % k))
        data = data / k
    return s[::-1]


if __name__ == '__main__':

    data = []

    for i in range(1, 101):
        data.append(i)

    for i in range(1, 101):
        data.append(i)

    for i in range(1, 101):
        data.append(i)

    data.append(123)

    k = 3

    kList = []

    for i in range(0, 301):
        kList.append(getK(data[i], k))

    res = ''

    for i in range(0, 32):
        if int(kList[0][i], k) + int(kList[1][i], k) >= k:
            res = res + str(int(kList[0][i], k) + int(kList[1][i], k) - k)
        else:
            res = res + str(int(kList[0][i], k) + int(kList[1][i], k))

    for j in range(2, 301):
        t = ''
        for i in range(0, 32):
            if int(res[i], k) + int(kList[j][i], k) >= k:
                t = t + str(int(res[i], k) + int(kList[j][i], k) - k)
            else:
                t = t + str(int(res[i], k) + int(kList[j][i], k))
        res = t

    fres = int(res, k)

    pass
