import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 전투력 시스템
        // 캐릭터가 가진 전투력 기준 칭호
        // 10000 이하는 WEAK 10001 ~ 100000 NORMAL, 100001 ~ 1000000 : STRONG

        int level = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());

        // 레벨
        String arr[] = new String[level];
        // 전투력
        int arr2[] = new int[level];

        for (int i = 0; i < level; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색으로 범위 찾기
        for (int i = 0; i < people; i++) {
            int fight = Integer.parseInt(br.readLine());

            int start = 0;
            int end = level-1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if(arr2[mid] < fight) {
                    start = mid + 1;
                } else {
                    end = mid - 1 ;
                }
            }

            // 효율성을 위한 sb
            sb.append(arr[start] + "\n");
        }

        System.out.println(sb);

    }

}