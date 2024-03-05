import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] dis;
    static ArrayList<Node>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        // 만나는 길에 있는 소들에게 여물줘야함
        // 최소한의 소만 보자!
        // 양방향

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 헛간
        n = Integer.parseInt(st.nextToken());
        // 길
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int food = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, food));
            list[b].add(new Node(a, food));
        }

        check = new boolean[n + 1];
        dis = new int[n + 1];

        Arrays.fill(dis, 50000001);

        dijk();

        System.out.println(dis[n]);

    }

    public static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void dijk() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        dis[1] = 0;
        que.add(new Node(1, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if(!check[now.v]) {
                check[now.v] = true;
            } else {
                continue;
            }

            for (int i = 0; i < list[now.v].size(); i++) {
                Node next = list[now.v].get(i);

                if(dis[next.v] > dis[now.v] + next.cost) {
                    dis[next.v] = dis[now.v] + next.cost;
                    que.add(new Node(next.v, dis[next.v]));
                }
            }
        }

    }

}