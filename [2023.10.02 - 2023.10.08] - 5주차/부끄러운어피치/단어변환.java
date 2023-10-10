import java.util.*;

class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0; // 목표 단어가 words 배열에 없으면 변환 불가능
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin); // 시작 단어 큐에 추가
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(target)) {
                    return answer; // 목표 단어에 도달하면 최소 변환 횟수 반환
                }

                for (String word : words) {
                    if (canTransform(currentWord, word)) {
                        queue.offer(word); // 현재 단어에서 변환 가능한 단어를 큐에 추가
                    }
                }
            }

            answer++;
        }

        return 0; // 목표 단어로 변환할 수 없는 경우
    }

    private boolean canTransform(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;

                if (diffCount > 1) {
                    return false; // 한 번에 한 글자씩만 변환 가능하므로 2글자 이상 다른 경우는 불가능
                }
            }
        }

        return diffCount == 1; // 한 글자만 다른 경우 변환 가능
    }
}