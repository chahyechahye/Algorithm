import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 같은 원소가 들어간 수열 싫음
        // 같은 원소가 K개 이하로 들어있는 최장 연속 부분 수열의 길이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 수열
        int arr[] = new int[n];
        // 카운트 배열
        int cnt[] = new int[100001];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 길이
        int max = 0;
        // 투포인터
        int start = 0;
        int end = 0;

        // end가 arr 끝까지 닿을 때까지
        while(end < arr.length) {
            // cnt 배열이 최대 갯수를 넘지 않을 때만
            while(end < arr.length && cnt[arr[end]] < k) {
                cnt[arr[end]]++;
                end++;
            }
            // 두 거리 간 길이
            int leng = end - start;
            if(max < leng) {
                max = leng;
            }
            // 스타트 지점 옮기기 전에 start의 갯수 하나 줄이기
            cnt[arr[start]]--;
            // 스타트 지점 옮기기
            start++;
        }

        System.out.println(max);

    }

}