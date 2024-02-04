import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 반 배정  키 순
        // 같은 키 없음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int tc = Integer.parseInt(st.nextToken());

            int arr[] = new int[20];

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            // 앞의 값보다 큰 만큼 cnt++
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < j; k++) {
                    if(arr[k] > arr[j]) {
                        cnt++;
                    }
                }
            }

            sb.append(tc+ " " + cnt + "\n");

        }

        System.out.println(sb);

    }

}