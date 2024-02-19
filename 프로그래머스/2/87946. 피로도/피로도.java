class Solution {
    
    public int answer;
    public boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        
        // xx게임 피로도 시스템 (0이상의 정수)
        // 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"
        // 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"
        
        check = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);

        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i<dungeons.length; i++) {
            if(!check[i] && dungeons[i][0] <= k) {
                check[i] = true;
                dfs(depth + 1, k-dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }
}