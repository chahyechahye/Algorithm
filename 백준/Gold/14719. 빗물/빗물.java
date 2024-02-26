import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 고이는 빗물 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int height[] = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        // 블록 높이
        for (int i = 0; i < m; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 빗물
        int rain = 0;

        // 기준이 될 블록 순회
        for (int i = 1; i < m - 1; i++) {
            // 왼쪽 블록
            int left = 0;
            // 오른쪽 블록
            int right = 0;

            // 기준에서 왼쪽 중 가장 높은 블록
            for (int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            // 기준에서 오른쪽 중 가장 높은 블록
            for (int j = i + 1; j < m; j++) {
                right = Math.max(height[j], right);
            }

            // 현재 블록이 왼쪽과 오른쪽 블록보다 작을 때 제일 낮은 블록과의 차이 더해줌
            if(height[i] < left && height[i] < right) {
                rain += Math.min(left, right) - height[i];
            }
        }

        System.out.println(rain);

    }

}