class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // 땅따먹기!
        // n행 4열 모든 칸에 점수!
        // 각 행 중 한 칸만 밟아야함
        // 같은 열은 못밟음!
        
        for(int i = 1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        for(int i = 0; i<4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
          
        return answer;
    }
}