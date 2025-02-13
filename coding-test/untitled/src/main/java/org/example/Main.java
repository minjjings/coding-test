package org.example;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        // 테스트 입력
        String input = "())(())";
        System.out.println("result: " + findLongestValidParentheses(input));
    }

    public static int findLongestValidParentheses(String s) {
        // ArrayDeque를 사용하여 인덱스를 저장하는 스택을 구현
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // 초기값을 스택에 넣어줌 (유효한 괄호 쌍의 시작 인덱스를 찾기 위함)

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 여는 괄호는 스택에 인덱스를 푸시
                stack.push(i);
            } else {
                // 닫는 괄호는 짝을 맞추기 위해 스택에서 값을 팝
                stack.pop();

                if (stack.isEmpty()) {
                    // 스택이 비어있으면 새로운 시작점을 넣어줌
                    stack.push(i);
                } else {
                    // 짝이 맞은 괄호의 길이를 계산
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
