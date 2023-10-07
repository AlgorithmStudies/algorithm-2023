import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map=new HashMap();
        
        int depth=0;
        for(char s:skill.toCharArray()){
            map.put(s, depth);
            depth++;
        }
        
        int cnt=0;
        for(String tree:skill_trees){
            if(checkTree(map, tree))
                cnt++;
        }
        
        return cnt;
    }
    
    private boolean checkTree(Map<Character, Integer> map, String tree){
        char[] treeArr=tree.toCharArray();
        
        int depth=-1;
        for(char t:treeArr){
            if(map.containsKey(t)){
                int skillDepth=map.get(t);
                
                if(skillDepth!=depth+1)
                    return false;
                
                depth=skillDepth;
            }
        }
        
        return true;
    }
}
