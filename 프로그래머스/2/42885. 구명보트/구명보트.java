import java.util.Arrays;

class Solution {
    
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int answer = 0;
        int num = people.length - 1;
        for(int i = 0; i <= num; i++, answer++)
            while(num > i && people[i] + people[num--] > limit)
                answer++;
        return answer;
    }
}

