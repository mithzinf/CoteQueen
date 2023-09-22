 import java.util.Arrays;

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
            
//1번째 방법 
//sorting,loof를 활용한 솔루션
//1. participant, completion 두 배열을 정렬-sort-한다 (그러면 알파벳순으로 abc, ab 이렇게 리스트화 됨!!)
        Arrays.sort(participant);
        Arrays.sort(completion);
//2. 기준을 completion으로 두고 두 배열이 다를 때까지 없는 선수를 찾는다.
        int i = 0;
        for(; i<completion.length ; i++) {
            if(!participant[i].equals(completion[i]))
                break;
        }
//3. 예외처리 - 혹여나 마지막까지 왔다면, 마지막 선수가 완주하지 못한 선수다. (자동적으로)
        return participant[i];
    }
}

