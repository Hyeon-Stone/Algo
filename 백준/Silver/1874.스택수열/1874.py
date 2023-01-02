import sys
import random

def power(x, y, p): # modular exponentiation.
    res = 1;
    x = x % p;
    while (y > 0):
        if (y & 1):
            res = (res * x) % p;
        y = y>>1; 
        x = (x * x) % p;
    return res;


def  MR_test(d, n):
    a = 2 + random.randint(1, n - 4);
    x = power(a,d,n)
    if (x == 1 or x == n - 1):
        return True;
    while d != n-1:
        x = (x * x) % n;
        d *= 2;
        if (x == 1):
            return False;
        if (x == n - 1):
            return True;
    return False;

def isPrime( n, k):
    d = n - 1;
    if (n <= 1 or n == 4):
        return False;
    if (n <= 3):
        return True;
        
    while (d % 2 == 0):
        d //= 2;

    for _ in range(k):
        if (MR_test(d, n) == False):
            return False;
    return True;

m, n = [int(sys.stdin.readline().strip()) for _ in range(2)]
PrimeList = []
for i in range(m,n+1):
    if(isPrime(i, 4)):
        PrimeList.append(i)
if len(PrimeList) == 0:
    print("-1")
else:
    print(sum(PrimeList))
    print(min(PrimeList))