import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 프로그래머스팀 기능개선 작업 수행
        // 진도가 100%일 때 서비스 반영
        // 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞의 기능보다 먼저 개발될 수 있음
        // 뒤의 기능은 앞에 있는 기능이 배포될 때 함께 배포
        // 배포되어야 하는 순서대로 작업의 진도가 적힌 정수배열 progresses
        // 각 작업의 개발 속도가 적힌 정수배열 speeds
        
        int cnt = 0;
        int work[] = new int[progresses.length];
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i<progresses.length; i++) {
            if((100-progresses[i]) % speeds[i] == 0) {
                work[i] = (100-progresses[i]) / speeds[i];
            } else {
                work[i] = ((100-progresses[i]) / speeds[i]) + 1;
            }
            que.add(work[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        int before = que.peek();
        
        while(!que.isEmpty()) {
            if(before >= que.peek()) {
                que.poll();
                cnt++;
            } else {
                list.add(cnt);
                cnt=1;
                before = que.poll();
            }
        }
        
        list.add(cnt);
        
        int answer[] = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}