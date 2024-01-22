import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        
        
        for(right = people.length-1; right>=left; right--) {
            if(people[right] + people[left] > limit) {
                answer++;
            }
            else {
                answer++;
                left++;
            }
        }
        
        return answer;
    }
}