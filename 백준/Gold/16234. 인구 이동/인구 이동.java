import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int map[][];
    static int ud[] = {-1, 0, 1, 0};
    static int lr[] = {0, -1, 0, 1};

    static boolean[][] check;
    static boolean isCheck = false;

    // 연합 나라 좌표 저장
    static ArrayList<Node> list;


    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        // n x n 크기의 땅 , 한 칸 = 1 x 1
        // 각각 땅에는 나라 하나씩 존재
        // r행 c열에는 A[r][c] 명 살고 있음
        // 국경선 존재
        // 인구 이동 방법 (하루 단위, 더 이상 이동이 없을 때까지 지속) >>>
        // 국경선을 공유하는 두 나라 인구 차이가 l명 이상 r명 이하면 두 나라 국경선 하루간 안열림
        // 국경선이 모두 열렸으면 인구 이동 시작
        // 국경선이 열려 있어서 인접한 칸만으로 이동할 수 있으면 하루 동안 연합 상태
        // 연합인 각 칸의 인구수 = (연합 인구수 / 연합을 이루는 칸의 개수) ***소수점 버림
        // 연합 해체, 국경선 닫음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    public static int move() {
        // 인구 이동 날 수
        int day = 0;

        // 인구 이동이 더 이상 발생하지 않을 때까지
        while (true) {
            isCheck = false;
            check = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 방문하지 않았다면
                    if(!check[i][j]) {
                        // 국경선 확인하며 연합의 총 인구수 구하기
                        int sum = bfs(i, j);
                        // 연합이 형성됐으면
                        if(list.size() > 1) {
                            // 인구 이동
                            people(sum);
                            // 인구 이동 완료
                            isCheck = true;
                        }
                    }
                }
            }

            // 인구 이동이 더 이상 발생하지 않으면
            if(!isCheck) {
                return day;
            }
            // 발생하면 일 수 ++
            day++;

        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        // 시작점 추가
        que.add(new Node(x, y));
        check[x][y] = true;
        // 연합에 속한 나라의 좌표 저장 리스트 초기화
        list = new ArrayList<>();
        // 시작점 리스트에 추가
        list.add(new Node(x, y));
        // 연합의 총 인구수 초기화
        int sum = map[x][y];

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + ud[i];
                int ny = now.y + lr[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny]) {
                    int diff = Math.abs(map[now.x][now.y] - map[nx][ny]);
                    // 인구 차이 범위 내
                    if(l <= diff && diff <= r) {
                        que.add(new Node(nx, ny));
                        // 다음 위치를 연합에 추가
                        list.add(new Node(nx, ny));
                        // 다음 위치의 인구수를 연합 총 인구수에 추가
                        sum += map[nx][ny];
                        // 다음 위치 방문 완료
                        check[nx][ny] = true;
                    }
                }
            }

        }

        // 연합 인구수 반환
        return sum;

    }

    public static void people(int sum) {
        int avg = sum / list.size();
        for (Node i : list) {
            map[i.x][i.y] = avg;
        }
    }

}