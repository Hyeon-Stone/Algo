def solution(numbers):
    numbers = list(map(str, numbers))
    # 333
    # 303030
    # 343434
    # 문잦열비교에서는 사전순과 같음 34 -> 3 -> 30 순
    numbers.sort(key=lambda x: x*3, reverse=True)
    return str(int(''.join(numbers)))