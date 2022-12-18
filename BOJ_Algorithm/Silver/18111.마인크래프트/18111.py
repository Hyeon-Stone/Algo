import sys
n, m, B = map(int, sys.stdin.readline().split(' '))
lvalue = [(list(map(int, sys.stdin.readline().split(' ')))) for _ in range(n)]

min_time = 1e9
fin = 0
for floor in range(257):
    use_block , extract_block= 0, 0
    for i in range(n):
        for j in range(m):
            if lvalue[i][j] >= floor :
                extract_block += lvalue[i][j] - floor
            else:
                use_block += floor - lvalue[i][j]
                
    if use_block <=  extract_block + B:
        if extract_block*2 + use_block <= min_time:
            min_time = extract_block*2 + use_block
            fin = floor

print(min_time, fin)