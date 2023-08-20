package 신혜영;
import java.util.*;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            queue.add(str);
        }

        for (int i = 0; i < s.length(); i++) {
            String first = queue.poll();
            queue.add(first);

            Stack<String> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                String last = queue.poll();
                queue.add(last);

                if (stack.isEmpty()) {
                    stack.push(last);
                } else if (last.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else if (last.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else if (last.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    stack.push(last);
                }

            }

            if (stack.isEmpty()) {
                answer++;
            }

        }

        return answer;
    }
}
