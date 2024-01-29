import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 코니 다른 옷 조합 조아~
        
        int answer = 1;
        
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(int i = 0; i<clothes.length; i++) {
            String type = clothes[i][1];
            hash.put(type, hash.getOrDefault(type, 1) + 1);
        }
        
        for(String key : hash.keySet()) {
            answer *= hash.get(key);
        }
        
        return answer-1;
    }
}