import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    // 체크 배열
    static boolean check[];

    // 노드 간선 배열
    static int arr[][];

    // 노드, 간선, 시작번호
    static int node, line, start;

    static Queue<Integer> que= new LinkedList<>();

    public static void main(String args[]) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 노드 배열 생성
        arr = new int[node+1][node+1];
        // 체크 배열 생성
        check = new boolean[node+1];

        // 노드 배열 채우기
        for(int i = 0; i<line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");

        // check 배열 초기화
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);

    }

    public static void dfs(int start) {

        // 처음은 방문 했다~ 치고
        check[start] = true;
        sb.append(start + " ");

        // dfs 실행이 먼저 되게 하기 위해 i를 0부터 시작
        for(int i = 0; i<=node; i++) {
            // 간선이 연결되어 있고 check가 되어있지 않다면 탐색이 안 된것!
            if(arr[start][i] == 1 && !check[i]) {
                // 들어가자
                dfs(i);
            }
        }

    }

    public static void bfs(int start) {

        que.add(start);
        check[start] = true;

        while(!que.isEmpty()) {
            start = que.poll();
            sb.append(start + " ");

            for(int i = 1; i <= node; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    que.add(i);
                    check[i] = true;
                }
            }
        }

    }

}