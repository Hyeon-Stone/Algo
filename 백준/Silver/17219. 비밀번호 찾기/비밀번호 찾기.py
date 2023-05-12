import sys
input = sys.stdin.readline

n, m = map(int, input().split())
sitemap = {}
for _ in range(n):
    site, pw = input().rstrip().split()
    sitemap[site] = pw
for _ in range(m):
    print(sitemap[input().rstrip()])