import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<Integer>();

        //LIFO-STACK - 맨뒤에있는걸 맨먼저 쌓아야함
        //각각의 작업이 완료되는데 걸리는 기간 스택에 저장
        for (int i = progresses.length - 1; i >= 0; i--)
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        //남은 진척률을 진도로 나누면 ==> 일자 + 1 이유는 나머지 진척률을 채우려면 하루가 더 필요함
        List<Integer> answer = new ArrayList<Integer>();

        while (!stack.isEmpty()) {
            int cnt = 1;

            int top = stack.pop();

            //앞에 작업이 안끝나면 끝날때까지 기다렸다가 같이 배포되므로 cnt를 늘려준다.
            while (!stack.isEmpty() && stack.peek() <= top) {
                cnt++;
                stack.pop();
            }

            answer.add(cnt);
        }

        return answer;
    }
}