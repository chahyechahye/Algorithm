import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 카드는 차례로 1~n의 번호 가짐
        // 1번 카드가 가장 위 , n번 카드가 가장 아래 순서

        Queue<Integer> que = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++) {
            que.offer(i);
        }

        while (que.size()!=1) {
            que.poll();
            int a = que.poll();
            que.offer(a);
        }

        System.out.println(sb.append(que.poll()));

    }

}