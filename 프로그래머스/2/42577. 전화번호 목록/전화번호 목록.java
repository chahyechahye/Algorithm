import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 전화번호 적힌 전화번호 중 한 번호가 다른 번호의 접두어인 경우
        // 어떤 번호가 다른 번호의 접두어 false 아니면 true
        
        Set<String> numSet = new HashSet<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            numSet.add(phone_book[i]);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(numSet.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}