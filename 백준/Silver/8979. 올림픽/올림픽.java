import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 올림픽은 참가에 의의 공식적으로는 순위 X 비공식적인 국가간 순위
        // 금, 은, 동메달 수 주어지면 규칙으로 어디가 더 잘했나 봄
        // 1. 금메달이 많은 곳
        // 2. 금메달이 같으면 은메달이 많은 곳
        // 3. 금, 은이 모두 같으면 동메달이 같은 곳
        // 금,은,동 수가 같다면 두 나라 등수 같음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 국가의 수
        int n = Integer.parseInt(st.nextToken());
        // 등수를 알고 싶은 국가
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][4];

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 금은동 순으로 compare 정리
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                if(o1[2] == o2[2]) {
                    return Integer.compare(o1[3], o2[3]);
                }
                return Integer.compare(o1[2], o2[2]);
            }
            else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 위치 저장할 곳
        int loca = 0;
        // rank 매길 곳
        int rank = 1;

        // 원하는 국가 인덱스 찾기
        for (int i = 0; i < n; i++) {
            if(arr[i][0] == k) {
                loca = i;
                break;
            }
        }

        // sort라서 정렬 거꾸로 되어있음
        for (int i = n - 1; i >= 0 ; i--) {
            // 갯수가 같을 때까지 반복
            if(arr[i][1] == arr[loca][1] && arr[i][2] == arr[loca][2] && arr[i][3] == arr[loca][3]) {
                break;
            }
            // 갯수가 다르면 rank++
            else rank++;
        }

        System.out.println(rank);

    }

}