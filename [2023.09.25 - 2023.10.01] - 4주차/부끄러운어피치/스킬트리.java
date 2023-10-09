public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            if (validation(skill, skillTree)) {
                answer++;
            }
        }

        return answer;
    }

    //배워야할 스킬이 스킬트리 인덱스로 설정한다.
    //현재 배워야할 스킬인덱스가 스킬트리보의 인덱스보다 큰지 검사..
    //pre(비교해야할 스킬트리의 인덱스) 와 현재 배워야할 스킬트리의 인덱스가 같으면 현재 지정된 스킬트리 인덱스 초기화
    private boolean validation(String skill, String skillTree) {
        int prevIdx = -1; // 이전 스킬의 인덱스 초기화

        for (char currentSkill : skillTree.toCharArray()) {
            //현재 배워야 할 스키
            int currentIdx = skill.indexOf(currentSkill);

            // 스킬의 순서가 올바르지 않으면 false 반환
            if (currentIdx > prevIdx + 1) {
                return false;
            }

            // 스킬을 배우지 않은 순서대로 배우는 경우, 이전 스킬 인덱스 갱신
            if (currentIdx == prevIdx + 1) {
                prevIdx = currentIdx;
            }
        }

        return true;
    }
}
