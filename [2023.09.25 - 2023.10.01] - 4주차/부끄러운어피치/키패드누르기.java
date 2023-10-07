public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftPos = 10; // '*' 키패드의 위치 (왼손 시작 위치)
        int rightPos = 12; // '#' 키패드의 위치 (오른손 시작 위치)

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftPos = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightPos = number;
            } else {
                int leftDistance = getDistance(leftPos, number);
                int rightDistance = getDistance(rightPos, number);

                if (leftDistance < rightDistance) {
                    answer.append("L");
                    leftPos = number;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightPos = number;
                } else { // 거리가 같다면 주어진 손잡이(hand)에 따라 결정
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = number;
                    } else {
                        answer.append("R");
                        rightPos = number;
                    }
                }
            }
        }

        return answer.toString();
    }

    private int getDistance(int pos, int target) {
        int[][] keypad = {
                {3, 1}, {0, 0}, {0, 1}, {0, 2},
                {1, 0}, {1, 1}, {1, 2},
                {2, 0}, {2, 1}, {2, 2},
                {3, 0}, {3, 2}
        };

        int x1 = keypad[pos][0];
        int y1 = keypad[pos][1];
        int x2 = keypad[target][0];
        int y2 = keypad[target][1];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        키패드누르기 keypadPress = new 키패드누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = keypadPress.solution(numbers, hand);
        System.out.println("누른 키패드 순서: " + result);
    }
}





