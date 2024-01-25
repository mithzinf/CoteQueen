import java.util.Stack;

public class Solution {
    public boolean solution(String s) {
        // 스택을 활용하여 열린 괄호의 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 열린 괄호일 경우 인덱스를 스택에 추가
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                // 닫힌 괄호일 경우 스택이 비어있는지 확인 후 조건에 따라 처리
                if (!stack.isEmpty()) {
                    stack.pop(); // 대응되는 열린 괄호 제거
                } else {
                    return false; // 대응되는 열린 괄호가 없는 경우 올바르지 않은 괄호
                }
            }
        }

        // 모든 문자를 확인한 후 스택이 비어있으면 올바른 괄호
        return stack.isEmpty();
    }
    
}