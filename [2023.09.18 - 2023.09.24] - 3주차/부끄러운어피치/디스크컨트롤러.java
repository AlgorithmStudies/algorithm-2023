import java.util.Arrays;
import java.util.PriorityQueue;
class 디스크컨트롤러 {
    /*풀이!
        jobs를 시작시간을 기준으로 정렬, 소요시간을 기준으로 만들어주기
        우선순위큐를 사용
    */
    public int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 마지막 작업의 end시간
        int index = 0; // 작업배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 요청시간 오름차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 처리 시간 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while (count < jobs.length) {
            //작업 시작시간 < 직전 작업 끝난시간 경우 뒤에 다시처리해야하므로 큐에 삽입, 대기열에 추가
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);//
            }

            // 큐가 비어있는 경우 대기중인 작업이 없으므로 작업 배열 추가
            if (pq.isEmpty()) {
                end = jobs[index][0];//작업의 소요시간
            } else {

                int[] jobsTemp = pq.poll();
                // 걸린 시간 누적합
                answer += jobsTemp[1] + end - jobsTemp[0];
                end += jobsTemp[1];//작업소요시간을 최종 누적끝난시간
                count++;
            }
        }

        return answer / jobs.length;
    }
}
