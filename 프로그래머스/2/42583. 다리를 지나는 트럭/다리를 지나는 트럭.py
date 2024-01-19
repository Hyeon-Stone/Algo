from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = [0] * bridge_length
    while (truck_weights) :
        answer += 1
        weight += bridge.pop(0)
        if ((weight - truck_weights[0]) >= 0) :
            truck = truck_weights.pop(0)
        else : 
            truck = 0
        bridge.append(truck)
        weight -= truck 

    return answer + len(bridge)
            
        
