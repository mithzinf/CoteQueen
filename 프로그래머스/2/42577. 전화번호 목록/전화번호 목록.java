import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        
        //1. phone_book을 오름차순으로 정렬
        Arrays.sort(phone_book);
            
        //2. 1중 loof를 돌면서 앞번호가 뒷번호의 접두어인지를 확인하기
        for(int i = 0; i<phone_book.length - 1; i++) {
            //length는 1부터 카운트해서 배열의 인덱스값과 맞지가 않음.. 그래서 -1을 해서 0부터 시작하게끔 설정값 조정
            //phone_book[i+1] : 뒷번호
            if((phone_book[i+1]).startsWith(phone_book[i]))
                return false;
            }
        //3. 여기까지 오지 못했으면 접두어가 없다는 것 췍췍
        return true;
    }
}