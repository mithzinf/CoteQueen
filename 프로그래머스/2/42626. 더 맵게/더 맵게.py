import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    #스코빌 배열을, heap 으로 변환 : heapify
    
    #주어진 스코빌지수 K보다 작은 스코빌 지수값을 배열에서 탐색해서 찾아냄
    while scoville[0] < K:
        mix_s = heapq.heappop(scoville) + (heapq.heappop(scoville)*2)
        heapq.heappush(scoville,mix_s)
        answer += 1
        
        if scoville[0] < K and len(scoville)==1:
            return -1

    
    return answer