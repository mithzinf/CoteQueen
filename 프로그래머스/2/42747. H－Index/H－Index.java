import java.util.*;

class Solution {
    public int solution(int[] citations) {
                int answer = 0;
                Arrays.sort(citations); //0 1 3 5 6
             
                int n = citations.length; //n = 5
//                int h = 
            
        
        for(int i = 0; i<n-1; i++) { //i=0 ~ i=4까지 순회
             int h_index = citations.length - i;
            if(citations[i] >= h_index) { //citations[0] vs 5
                answer = h_index;
                    break;
                
            }
        }
       
        return answer;
    }
    
}