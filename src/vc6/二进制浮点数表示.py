# 二进制浮点数表示
if __name__ == '__main__':

    num = 0.625

    res = '0.'

    count = 0

    while num != 0.0000000:
        num *= 2
        if num >= 1:
            res = res + str(int(num))
            num -= 1
        else:
            res = res + str(int(num))
        if count > 33:
            break

    pass
