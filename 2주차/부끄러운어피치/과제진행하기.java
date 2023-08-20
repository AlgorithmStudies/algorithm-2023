package 부끄러운어피치;

import java.util.*;

class 과제진행하기 {
    public String[] solution(String[][] plans) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<homeWork> homework = new ArrayList<>();
        Stack<homeWork> stack = new Stack<>();//작업을 저장할 스택
        HashMap<Integer, homeWork> info = new HashMap<>();
        int length = plans.length;//

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int playTime = Integer.parseInt(plan[2]);//진행걸리는시간
            int start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);//시작타임 분단위 변환
            info.put(start, new homeWork(plan[0], start, playTime));//작업별 시작시간 걸리는시간
            homework.add(new homeWork(plan[0], start, playTime));//작업명 시작시간 걸리는 시간
        }

        homework.sort((s1, s2) -> s1.start != s2.start ? s1.start - s2.start : s1.playTime - s2.playTime);
//시작시간이 빠른순으로 정렬 ..
        int time = homework.get(0).start;//첫작업의 시작시간
        int cnt = 0;//

        while (cnt < length) {  //전체 작업의 수가 더 크면 남아있다는 뜻으로 계속 진행
            if (!stack.isEmpty()) {//남은 작업이 있으면
                stack.peek().playTime -= 1;//작업시간 -1
                if (stack.peek().playTime == 0) {//작업을 모두 했다는 의미
                    result.add(stack.peek().name);//결과 배열에 저장
                    stack.pop();//남은 작업에서 삭제
                    cnt++;//작업한 개수
                }
            }
            //
            if (info.containsKey(time)) {//작업중에 첫작업의 시작시간과 같은게 있으면
                stack.add(info.get(time));//남은 작업에 추가.
            }
            time++;//작업수행할때마다 작업의 시작시간을 +1씩 늘린다.
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }

    static class homeWork {
        String name;
        int start;
        int playTime;

        public homeWork(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}