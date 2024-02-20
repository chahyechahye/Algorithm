import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 비밀 통신 시스템 개발
        // n개의 높이가 서로 다른 수평 직선 왼쪽부터 오른쪽 방향으로 차례로 세움
        // 각 탑의 꼭대기에 레이저 송신기 설치
        // 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사
        // 탑의 기둥 모두에는 레이저 신호를 수신하는 장치 설치
        // 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만다는 단 하나의 탑에서만 수신 가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stk = new Stack<>();

        for (int i = 1; i <= n; i++) {
            // 현재 상자의 높이
            int top = Integer.parseInt(st.nextToken());
            // 스택이 비어있지 않을 때
            while (!stk.isEmpty()) {
                // 스택의 가장 높은 곳이 현재 높이보다 높으면
                if(stk.peek()[1] >= top) {
                    // 인덱스 출력
                    sb.append(stk.peek()[0] + " ");
                    break;
                }
                // 낮으면 꺼냄
                stk.pop();
            }
            // 스택이 비어있으면 0
            if(stk.isEmpty()) {
                sb.append("0 ");
            }
            // 상자의 인덱스와 높이 삽입
            stk.push(new int[] {i, top});
        }

        System.out.println(sb);

    }

}