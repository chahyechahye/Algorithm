import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int day = Integer.parseInt(st.nextToken());
        int plusDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int arr[] = new int[day];

        // 날짜 방문자 담기
        for (int i = 0; i < day; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 방문자 합
        int sum = 0;

        // 방문자 합 기본 값
        for (int i = 0; i < plusDay; i++) {
            sum+=arr[i];
        }

        // max값과 cnt값 설정
        int max = sum;
        int cnt = 1;
        
        // plusDay부터
        for (int i = plusDay; i < day; i++) {
            // 앞의 날짜 방문자 수 제거
            sum -= arr[i-plusDay];
            // 뒤의 날짜 방문자 수 추가
            sum += arr[i];
            // 합이 max보다 크면 max 교체 cnt 1로 초기화
            if(sum > max) {
                max = sum;
                cnt = 1;
            }
            // sum과 max가 같으면 cnt++
            else if (sum == max) {
                cnt++;
            }
        }
        
        if(max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max + "\n" + cnt);
        }

        System.out.println(sb);

    }

}