import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<Integer>();
        //스택은 계속 위로 쌓고 마지막에 쌓인것을 맨먼저 꺼낸다.
        for (int i = progresses.length - 1; i >= 0; i--)
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        //각각의 작업이 완료되는 일을 스택으로 만들어 저장한다.
        //남은 진척률을 진도로 나누면 ==> 일자 + 1 이유는 나머지 진척률을 채우려면 하루가 더 필요함
        List<Integer> s = new ArrayList<Integer>();

        while (!stack.isEmpty()) {
            int cnt = 1;

            int top = stack.pop();

            //앞에 작업이 안끝나면 끝날때까지 기다렸다가 같이 배포되므로 cnt를 늘려준다.
            while (!stack.isEmpty() && stack.peek() <= top) {
                cnt++;
                stack.pop();
            }

            s.add(cnt);
        }

        int[] answer = new int[s.size()];
        //배포시점별 기능 배포수 배열
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.get(i);
        }

        return answer;
    }
}
