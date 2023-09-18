import java.util.*;
class Solution {
/*
* 1. 최소큐와 최대큐로 나눈다.(최대값 최소값 반환을 위해)
* 문제에서 말한대로 구현한다. 최소값 삭제 및 최댓값 삭제 삽입시 최소큐와 최대큐에 삽입한다.
* 최소큐는  큐에서 가장 먼저 꺼내는 수가 최소값
* 최대큐는 큐에서 가장 먼저 꺼내는 수가 최댓값
*
 * */
    public  int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());

        int val = 0;

        for(int i = 0; i < operations.length; i++){
            String op = operations[i];
            String opType = op.substring(0,1);
            // 삭제
            if(opType.equals("D")) {
                // 최솟값 삭제
                if(op.charAt(2) == '-') {
                    if(!minQueue.isEmpty()) {
                        val = minQueue.peek();
                        minQueue.poll();
                        maxQueue.remove(val);
                    }
                }
                // 최댓값 삭제
                else {
                    if(!maxQueue.isEmpty()) {
                        val = maxQueue.peek();
                        maxQueue.poll();
                        minQueue.remove(val);
                    }
                }
            }
            else {  // 추가
                int value = Integer.parseInt(op.substring(2));
                maxQueue.offer(value);
                minQueue.offer(value);
            }
        }
        // 큐가 비어있지 않으면 [최댓값, 최솟값]
        if(!maxQueue.isEmpty()){
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }

        return answer;
    }
}
