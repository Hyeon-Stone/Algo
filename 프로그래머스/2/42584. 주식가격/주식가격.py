def solution(prices):
    answer = [0] * len(prices)
    for i in range(len(prices)-1):
        price = prices[i]
        for j in range(i+1, len(prices)):
            answer[i] += 1
            if (price >  prices[j]):
                break
                
    return answer