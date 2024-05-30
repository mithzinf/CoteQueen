def solution(participant, completion):
    answer = ''
    hash_dict={} # hash dictionary
    sumHash=0
    for i in participant:
        hash_dict[hash(i)]=i # participant hash 인덱스 넣기
        sumHash+=hash(i) # hash 총합
        
    for j in completion:
        sumHash-=hash(j) # completion의 hash값들 빼기
        
    return hash_dict[sumHash] # 남은 hash값에 해당하는 선수가 완주 못한 선수