import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static Queue<node> que = new LinkedList<>();

    public static int n, m, locaN, locaM, stvalue;

    public static int arr[][];
    public static boolean check[][];
    public static int distance[][];
    public static int[] lr = {0, -1, 0, 1};
    public static int[] ud = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 지도 값
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 지도
        arr = new int[n][m];
        // 방문 체크
        check = new boolean[n][m];
        // 거리 계산
        distance = new int[n][m];

        // 지도 값 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                stvalue=Integer.parseInt(st.nextToken());
                // 2일 경우 좌표 따로 저장하여 후에 시작 위치로 선정
                if(stvalue==2) {
                    locaN=i;
                    locaM=j;
                    check[i][j] = true;
                }
                arr[i][j] = stvalue;
            }
        }

        bfs(locaN, locaM);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 만약 도달하지 못했고 갈수는 있는 곳이면 -1 출력
                if(check[i][j] == false && arr[i][j] == 1) {
                    sb.append(-1 + " ");
                }
                else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(int first, int second) {
        // que 에 값 넣어주고 시작
        que.add(new node(first, second));
        // 방문 했어용
        check[first][second] = true;

        while(!que.isEmpty()) {
            node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextud = now.x + ud[i];
                int nextlr = now.y + lr[i];

                // 범위
                if(nextud < 0 || nextud >= n || nextlr < 0 || nextlr >= m) {
                    continue;
                }
                // 방문 불가한 곳
                if(arr[nextud][nextlr] == 0) {
                    continue;
                }
                // 이미 방문한 곳
                if(check[nextud][nextlr] == true) {
                    continue;
                }

                que.add(new node(nextud, nextlr));
                // 거리 +1
                distance[nextud][nextlr] = distance[now.x][now.y] + 1;
                check[nextud][nextlr] = true;
            }

        }
    }

    static class node{
        public int x, y;
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}