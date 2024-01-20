import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] cards) {
        int card_Num = cards.length;
        //card의 개수는 곧, cards 배열의 길이와 같다.
        
        //상자를 열 때 다음 상자로 이동하는 경로를 저장하기..for문 이용해서 크게크게
        
        int[][] route = new int [card_Num][card_Num];
                for(int i = 0; i<card_Num; i++) {
                    route[i][cards[i] - 1] = 1;
        }  
            //route 배열의 각 원소 : 1 (있다) 혹은 0(없다) 의 값 가짐, 그래서 for문의 의미 : 2차원 배열의 값이 둘다 1일 때..! == 해당 상자에 해당 카드 번호가 있을 때!
            
            //상자를 열고 그 다음 상자로 이동하는 경로를 통해, 상자 중에서 연 상자의 개수를 PriorityQueue에 저장해야한다 -> 그래야 점수를 낼 수 있다
            
        PriorityQueue<Integer> counts = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < card_Num; i++) {
                    if(route[i][cards[i]-1] == 1) {
                    
                    int rt1 = i;
                    int rt2 = cards[i] - 1;
                    
                    //오픈한 상자의 갯수
                    int box = 0;
                    
                    while(route[rt1][rt2] != 0) {
                        //현재 상자를 연다
                        route[rt1][rt2] = 0;
                        
                        //연 상자의 개수를 늘린다
                        box++;
                        
                        //다음 상자의 경로 저장하기
                        rt1 = rt2;
                        rt2 = cards[rt1] -1;
                    }
                    
                    counts.add(box);
                }
            }   
            
            //1번 상자 그룹을 제외하고 남는 상자가 없다면? 0이다!
            if(counts.size() == 1)
                return 0;
            
            //1번 상자 그룹에 속한 상자의 갯수와 2번 상자 그룹에 속한 상자의 갯수 곱함
            //그 중에서도 상자의 수가 젤 많은 두 그룹를 셀렉함
            
            int group1 = counts.poll();
            int group2 = counts.poll();
                return group1 * group2;
        
    }
}    