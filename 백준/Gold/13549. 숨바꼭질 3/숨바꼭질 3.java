import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] check;

    static Queue<Node> que = new LinkedList<>();

    static int n, k;
    static int num = 100000;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {

        // 수빈.. 동생과 숨바꼭질 하는 착한 아이
        // 수빈.. 걷고 순간이동까지 할 줄 아는 아이
        // 범위 0~100000
        // 수빈이의 위치가 x일때
        // 걷기 : 1초 후 x-1 or x+1 의 위치
        // 순간이동 : 0초 후 2*x 의 위치

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        check = new boolean[num+1];

        bfs();

        System.out.println(min);


    }

    public static void bfs() {
        // 시작지점과 횟수
        que.add(new Node(n, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();
            check[node.x] = true;

            // 도달한경우
            // 먼저 방문한다 하여 time이 적은 게 아니므로 최소 시간 갱신 필요
            if(node.x == k) {
                min = Math.min(min, node.time);
            }

            // 순간이동은 time이 늘어나지 않음
            // 순간이동이 최소이기 때문에 가장 먼저 연산 필요
            if(node.x * 2 <= num && check[node.x * 2] == false) {
                que.add(new Node(node.x * 2, node.time));
            }
            if(node.x + 1 <= num && check[node.x + 1] == false) {
                que.add(new Node(node.x + 1, node.time+1));
            }
            if(node.x - 1 >= 0 && check[node.x - 1] == false) {
                que.add(new Node(node.x - 1, node.time+1));
            }

        }

    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}