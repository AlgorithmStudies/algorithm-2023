import java.util.*;

public class 보석쇼핑 {
    /*
    * 1. gems를 앞에서 부터 순회하는데 해당 gemCounter에서 해당 gem을 찾아 갯수 + 1을 해준다.
        2. 그리고 해당 gem을 selectedGems에 추가한다. 선택한 보석 리스트에 추가를 하는 것이다.
        3. while문을 통해 selectedGems에서 제거할만한 gem이 있는지 파악한다.
        * 제거 조건은 해당 gem이 gemCounter에서 2개 이상의 값을 가지고 있는지 여부다. 2개 이상인 경우
        *  해당 gem을 selectedGems에서 빼주고, start + 1을 해준다. 이미 보유하고 있는 리스트에서 해당 gem이 여러 개 있으므로 가장 앞에 있는
        *  gem은 제거를 하여 길이를 줄이기 위함이다. 만약 1개 이하인 경우는 해당 gem은 필수적으로 리스트에 포함되어야 하는 것이므로 while문을 종료한다.

        4. gemCounter의 사이즈 (keySet().size())와 gemSet의 사이즈가 동일하고(gemCounter가 모든 종류의 보석을 다 가지고 있다는 것을 의미)
        *  현재 seletedGems의 사이즈보다  end값(여태까지 모든 종류의 보석을 포함하고 있을 때의 selectedGems 크기의 최솟값)이
        * 작은 경우 startPoint와 end 값을 업데이트해준다.

        5. for문이 종료되었을 때 startPoint에는 조건을 만족하는 seletedGems의 시작 지점,
        *  end에는 조건을 만족하는 seletedGems의 사이즈가 저장되어있으므로 해당 값들을 리턴한다.
    * */

    public int[] solution(String[] gems) {
        Map<String, Integer> gemCounter = new HashMap<>();
        Queue<String> selectedGems = new LinkedList<>();
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

        int start = 0;
        int end = Integer.MAX_VALUE;
        int startPoint = 0;

        for (String gem : gems) {
            gemCounter.put(gem, gemCounter.getOrDefault(gem, 0) + 1);
            selectedGems.add(gem);

            while (true) {
                String targetGem = selectedGems.peek();

                if (gemCounter.get(targetGem) <= 1) {
                    break;
                }

                selectedGems.poll();
                start++;
                gemCounter.put(targetGem, gemCounter.get(targetGem) - 1);
            }

            if (gemCounter.size() == gemSet.size() && end > selectedGems.size()) {
                startPoint = start;
                end = selectedGems.size();
            }
        }

        return new int[] {startPoint + 1, startPoint + end};
    }
}