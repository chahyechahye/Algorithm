import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main (String args[]) throws IOException {

        // 정수 n을 1,2,3의 합으로 나타내는 방법의 수
        // 순서만 다른 것은 같다

        // 5

        // dp[n][1] = dp[n-1][1]
        // 1 3  1
        // 1 1 2  1
        // 2 2  1
        // 1 1 1 1  1

        // dp[n][2] = dp[n-2][1] + dp[n-2][2]
        // 1 1 1  2
        // 1 2  2
        // 3  2

        // dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]
        // 1 1  3
        // 2  3


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int dp[][] = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        // dp 설정
        for(int i = 4; i<10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        // t 값만큼 돌리기
        for(int i =0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            // 각 자리를 더한 dp값 합산
            sb.append(dp[n][1]+dp[n][2]+dp[n][3] + "\n");
        }

        System.out.println(sb);

    }

}