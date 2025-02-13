import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner를 사용하여 콘솔에서 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("괄호를 입력하세요:");


        // 사용자로부터 입력을 받음
        String input = scanner.nextLine();
        System.out.println("input "+input);

        // 결과 출력
        System.out.println("result: " + findLongestValidParentheses(input));

        scanner.close();
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
