import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        // 회전 : 리스트 사용
        List<String> list = new ArrayList<>();
        String[] str = s.split("");

        for (int i = 0; i < s.length(); i++) {
            list.add(str[i]);
        }


        // 올바른 괄호 문자열 확인 : 스택 사용
        Stack<String> stack = new Stack<>();
        int length = list.size();


        // 길이만큼 회전
        while (length > 0) {
            // stack 초기화
            int top = -1; // 삽입 인덱스
            stack.removeAllElements();

            for (String ch : list) {
                // 1. 열려 있는 괄호일 경우 스택에 삽입
                if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                    top++;
                    stack.add(ch);
                } else if ((top != -1) && (ch.equals(")") || ch.equals("}") || ch.equals("]"))) {
                    if (isChecked(ch, stack, top)) {
                        stack.remove(top);
                        top--;
                    } else {
                        break;
                    }
                } else {
                    stack.add(0, ch);
                }
            }
            // 3. 다 돌고 난 후 stack에 데이터가 남아있는 경우 false;
            if (stack.size() == 0) {
                answer++;

            }
            length--;

            // 괄호 회전
            list.add(list.get(0));
            list.remove(list.get(0));

        }

        return answer;
    }

    public boolean isChecked(String ch, Stack<String> stack, int top) {
        switch (ch) {
            case ")":
                if (stack.get(top).equals("(")) {
                    return true;
                }
                break;
            case "}":
                if (stack.get(top).equals("{")) {
                    return true;
                }
                break;

            case "]":
                if (stack.get(top).equals("[")) {
                    return true;
                }
                break;
        }
        return false;
    }
}