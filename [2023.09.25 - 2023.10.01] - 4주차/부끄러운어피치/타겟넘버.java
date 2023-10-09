public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            // 모든 숫자를 다 사용한 경우, 현재 합이 타겟과 같으면 1을 반환, 아니면 0을 반환
            return (currentSum == target) ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우와 빼는 경우의 경우의 수를 계산
        int add = dfs(numbers, target, index + 1, currentSum + numbers[index]);
        int subtract = dfs(numbers, target, index + 1, currentSum - numbers[index]);

        return add + subtract;
    }

    public static void main(String[] args) {
        타겟넘버 targetNumberDFS = new 타겟넘버();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = targetNumberDFS.solution(numbers, target);
        System.out.println("경우의 수: " + result);
    }
}





