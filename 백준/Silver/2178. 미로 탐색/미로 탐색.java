import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 배열
    static int arr[][];
    // 검사
    static boolean check[][];
    static int n, m, max;
    static Queue<int[]> que = new LinkedList<>();

    //상하
    static int [] ud = { -1, 1, 0, 0} ;

    //좌우
    static int [] lr = { 0, 0, -1, +1} ;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];
        check[0][0] = true;

        // 지도 입력
        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            for(int j = 0; j<m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(arr[n-1][m-1]);

    }

    public static void bfs(int x, int y) {

        // que에 좌표 배열 넣어주기
        que.add(new int[] {x, y});

        while(!que.isEmpty()) {
            // 현재 좌표 저장
            int now[] = que.poll();
            int nowud = now[0];
            int nowlr = now[1];

            for(int i = 0; i<4; i++) {
                // 다음 좌표들 확인
                int nextud = nowud + ud[i];
                int nextlr = nowlr + lr[i];

                if(nextud >= n || nextlr >= m || nextud < 0 || nextlr < 0) {
                    continue;
                };
                if(check[nextud][nextlr] || arr[nextud][nextlr] == 0) {
                    continue;
                }

                // que에 다음 값 넣기
                que.add(new int[] {nextud, nextlr});
                // 다음 좌표의 값을 현재의 +1로 설정하기
                arr[nextud][nextlr] = arr[nowud][nowlr] + 1;
                // 다음 좌표를 방문으로 체크
                check[nextud][nextlr] =  true;

            }

        }


    }



}