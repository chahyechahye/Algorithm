import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, count, max, area;
    static int arr[][];
    static boolean check[][];
    static Queue<Pair> que = new LinkedList<>();

    public static void main(String args[]) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n, m);

        System.out.println(sb);

    }

    public static void bfs(int a, int b) {

        count = 0;
        max = 0;

        int[] ud = {-1, 1, 0, 0};
        int[] lr = {0, 0, -1, 1};

        for(int i = 0; i<a; i++) {
            for(int j = 0; j<b; j++) {
                if(arr[i][j] == 0 || check[i][j]) {
                    continue;
                }

                check[i][j] = true;
                que.add(new Pair(i, j));
                count++;
                area = 0;

                while (!que.isEmpty()) {
                    Pair p = que.poll();
                    area++;

                    for(int k = 0; k<4; k++) {
                        int newud = p.x + ud[k];
                        int newlr = p.y + lr[k];

                        if(newud < 0 || newud >= a || newlr < 0 || newlr >= b) {
                            continue;
                        }

                        if(arr[newud][newlr] == 1 && !check[newud][newlr]) {
                            que.add(new Pair(newud, newlr));
                            check[newud][newlr] = true;
                        }

                    }

                }

                if(area > max) {
                    max = area;
                }

            }

        }

        sb.append(count +"\n"+max);

    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}