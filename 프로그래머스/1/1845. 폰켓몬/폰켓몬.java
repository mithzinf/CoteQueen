import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //배열 nums : N마리 폰켓몬의 종류 번호가 담긴 배열
        //int answer : 폰켓몬의 종류이자 구해야 할 최댓값
        //int pickNum : 내가 데리고 올 수 있는 폰켓몬 마리 수
        //Hashset 인터페이스 클래스 : 중복 자동 제거
        int answer = 0;
        int pickNum = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        if(pickNum > set.size()) answer = set.size();
        else answer = pickNum;
               
        
        return answer;
    }
}