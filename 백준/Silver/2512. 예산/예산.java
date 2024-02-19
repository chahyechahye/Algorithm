import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 예산 분배
        // 정해진 총액 이하에서 가능한 한 최대의 총 예상 배정
        // 1. 모든 요청이 배정될 수 있는 경우 요청 금액 그대로 배정
        // 2. 모든 요청이 배정될 수 없으면 정수 상한액을 계산해 그 이상인 에상요청에 상한액 배정
        // 상한액 이하의 요청에는 요청한 금액 그대로 배정

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // pay를 담을 공간
        int pay[] = new int[n];

        int left = 0;
        int right = -1;

        // pay를 돌며 총합과 max 금액 설정
        for (int i = 0; i < pay.length; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, pay[i]);
        }

        // 예산
        int money = Integer.parseInt(br.readLine());

        // 이진탐색
        while (left <= right) {
            // 중간값
            int mid = (left + right) / 2;
            // 예산의 합
            long plus = 0;
            for (int i = 0; i < n; i++) {
                // mid보다 pay가 크면 mid 더하기
                if(pay[i] > mid) {
                    plus += mid;
                } else {
                    // 그 외엔 pay[i] 더하기
                    plus += pay[i];
                }
            }
            // 총합이 money보다 작거나 같으면 left에 mid+1 해서 재조정
            if(plus <= money) {
                left = mid+1;
            } else {
                // 총합이 money보다 크면 right 재조정
                right = mid-1;
            }
        }

        System.out.println(right);

    }

}