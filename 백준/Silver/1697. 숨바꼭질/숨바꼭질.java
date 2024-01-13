import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k, loca;
    static Queue<Integer> que = new LinkedList<>();

    static int arr[] = new int[100001];

    public static void main(String args[]) throws IOException {

        // 숨바꼭질
        // 0~100000
        // 수빈이가 x일 때 걸으면 1초 후 x-1 / x+1로 이동
        // 순간이동하면 1초 후 2*x의 위치로 이동

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }

    }

    public static void bfs(int a) {

        que.add(a);
        arr[a] = 1;

        while(!que.isEmpty()) {
            loca = que.poll();

            for(int i = 0; i<3; i++) {
                int next;

                if (i == 0) {
                    next = loca + 1;
                } else if (i == 1) {
                    next = loca - 1;
                } else {
                    next = loca * 2;
                }

                if(next == k) {
                    System.out.println(arr[loca]);
                    return;
                }

                if(next >= 0 && next < arr.length && arr[next] == 0) {
                    que.add(next);
                    arr[next] = arr[loca] + 1;
                }
            }


        }

    }

}