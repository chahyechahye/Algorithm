import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int [][] fuel;
    public static int [][][] dp;
    public static int min;

    public static void main(String[] args) throws IOException {

        // 달 여행 자금 모으기 완료!
        // 지구와 우주 사이는 NxM행렬 우주선이 공간을 지닐 때 소모되는 연료 양 기록
        // 같은 방향으로 두번 움직일 수 없음
        // 연료를 아끼며 달에 착륙

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        fuel = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 행 초기값 설정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = fuel[0][i];
            }
        }

        dp();

        System.out.println(min);

    }

    public static void dp() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 왼쪽 위, 오른쪽 위 모두 범위일 때
                if (j - 1 >= 0 && j + 1 < m) {
                    // 같은 방향 제외하고 최솟값 비교하여 가져옴
                    dp[i][j][0] = fuel[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = fuel[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = fuel[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }
                // 오른쪽 위가 범위가 아닐 때
                else if (j - 1 >= 0) {
                    dp[i][j][0] = fuel[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = fuel[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    // 오른쪽 위는 불가
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
                // 왼쪽 위가 범위가아닐 때
                else {
                    // 왼쪽 위는 불가
                    dp[i][j][0] = Integer.MAX_VALUE;
                    dp[i][j][1] = fuel[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = fuel[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }
            }
        }

        // 최솟값 찾을 변수
        int minValue = dp[n - 1][0][0];
        
        // 회솟값 찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                minValue = Math.min(minValue, dp[n - 1][i][j]);
            }
        }

        min = minValue;

    }


}