import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 그래프
    static int [][] graph = new int[1001][1001];
    static int v;
    static int e;
    // 방문 체크
    static boolean[] checked = new boolean[1001];

    public static void dfs(int x) {
        if(checked[x] == true) {
            return;
        }
        else {
            checked[x] = true;
            // 연결 정점 있는지 확인
            for (int i = 1; i <= v; i++) {
                if(graph[x][i] == 1) {
                    dfs(i);
                }               
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int a;
        int b;
        int result = 0;

        // 간선 정보 입력 받고 인접 행렬에 저장
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            graph[a][b] = graph[b][a] = 1;
        }

        // 모든 정점의 연결 요소 확인
        for (int i = 1; i <= v; i++) {
            if(checked[i] == false) {
                dfs(i);
                result++;
            }
        }
        
        System.out.println(result);

    }
    
}