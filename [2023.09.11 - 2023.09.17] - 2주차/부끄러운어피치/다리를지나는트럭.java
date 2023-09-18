import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //다리길이, 견딜수있는 무게, 트럭무게배열
        int answer = 0;

        Queue<currentTruck> bridge = new LinkedList<>();
        int currentWeight = 0;
        int passedTruck = 0 ;
        int currentTime = 0;
        //모든 트럭이 건널때까지.... 제한을 주기위함
        while (passedTruck < truck_weights.length) {
            currentTime++;//경과시간 한 반복당 +1
            //트럭이 다리에서 빠져나갈때
            //1. 현재 시간과 큐에서 빠져나가려는 트럭의 진입 시간의 차가 bridge_length와 동일해야 한다.
            if (!bridge.isEmpty() && currentTime - bridge.peek().time == bridge_length) {
                currentTruck truck = bridge.poll();
                currentWeight -= truck.weight;//현재 다리에 가해진무게 - 빠져나간 트럭의 무게
            }

            //지나고있는 사이즈가 최대사이즈보다크면 다음턴
            if (bridge.size() >= bridge_length) {
                continue;
            }

            //현재 다리에 가해진 무개에 다음 트럭이 올라탔을때 > 다리가 견딜수있는 최대 무게면 다음턴
            if (currentWeight + truck_weights[passedTruck] > weight) {
                continue;
            }
            //현재 다리에 가해진무게에 추가 트럭무게를 더한다.
            currentWeight += truck_weights[passedTruck];
            //다리에 진입한 트럭의 진입시간
            //현재 다리에 가해진 무게와, 사이즈, 진입시간 초기화를 위한 로직
            currentTruck currentTruck = new currentTruck();
            currentTruck.setWeight(truck_weights[passedTruck]);
            currentTruck.setTime(currentTime);
            bridge.add(currentTruck);

            passedTruck++;
        }
        //현재 시간 + 마지막 트럭 시간
        return currentTime + bridge_length;
    }

    class currentTruck {
        private int weight;
        private int time;

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getTime() {
            return this.time;
        }

        public void setTime(int time) {
            this.time = time;
        }

    }
}